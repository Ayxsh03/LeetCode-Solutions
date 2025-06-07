chrome.runtime.onMessage.addListener((msg, sender, sendResponse) => {
  if (msg.action !== 'pushCode') return;

  chrome.storage.sync.get(['token','repo','folder'], data => {
    const { token, repo, folder } = data;
    if (!token || !repo) {
      return chrome.tabs.sendMessage(sender.tab.id, {
        action: 'alert',
        text: '👉 Please configure your GitHub token & repo in the extension Options.'
      });
    }

    const path = folder ? `${folder}/${msg.title}.txt` : `${msg.title}.txt`;
    const content = btoa(unescape(encodeURIComponent(msg.code)));

    fetch(`https://api.github.com/repos/${repo}/contents/${path}`, {
      method: 'PUT',
      headers: {
        'Authorization': `token ${token}`,
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        message: `Add LeetCode solution: ${msg.title}`,
        content
      })
    })
    .then(res => res.json())
    .then(resp => {
      const success = resp.content && resp.content.path;
      const text = success
        ? `✅ Saved to ${repo}/${path}`
        : `❌ Error: ${resp.message || JSON.stringify(resp)}`;
      chrome.tabs.sendMessage(sender.tab.id, { action:'alert', text });
    })
    .catch(err => {
      chrome.tabs.sendMessage(sender.tab.id, {
        action: 'alert',
        text: `❌ Network error: ${err.message}`
      });
    });
  });
});
