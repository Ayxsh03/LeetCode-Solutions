const form = document.getElementById('settings-form');
const status = document.getElementById('status');

// Load saved settings
chrome.storage.sync.get(['token','repo','folder'], data => {
  if (data.token)  document.getElementById('token').value  = data.token;
  if (data.repo)   document.getElementById('repo').value   = data.repo;
  if (data.folder) document.getElementById('folder').value = data.folder;
});

// Save on submit
form.addEventListener('submit', e => {
  e.preventDefault();
  const token  = document.getElementById('token').value.trim();
  const repo   = document.getElementById('repo').value.trim();
  const folder = document.getElementById('folder').value.trim();
  chrome.storage.sync.set({token,repo,folder}, () => {
    status.textContent = 'Settings saved!';
    setTimeout(() => status.textContent = '', 2000);
  });
});
