// helper to pull code out of Monaco editor if present
function getSubmissionCode() {
  if (window.monaco) {
    const models = window.monaco.editor.getModels();
    if (models.length) return models[0].getValue();
  }
  // fallback: collect line-by-line
  const spans = document.querySelectorAll('.view-lines span');
  return Array.from(spans).map(s => s.innerText).join('\n');
}

// wait for page to render
window.addEventListener('load', () => {
  // look for the “Accepted” badge
  const acceptedBadge = document.querySelector('.text-[color:var(--success-text)]');
  if (!acceptedBadge || !/Accepted/i.test(acceptedBadge.innerText)) return;

  // only insert once
  if (document.getElementById('lc-sync-btn')) return;

  // create button
  const btn = document.createElement('button');
  btn.id = 'lc-sync-btn';
  btn.textContent = 'Save to GitHub';
  btn.style = 'margin-left: 1em; padding: 0.3em 0.6em;';

  // append next to the problem title
  const header = document.querySelector('.css-10o4wqw h4');
  if (!header) return;
  header.appendChild(btn);

  btn.addEventListener('click', () => {
    const titleEl = header.querySelector('span');
    const title   = titleEl ? titleEl.innerText : 'solution';
    const code    = getSubmissionCode();
    chrome.runtime.sendMessage({ action: 'pushCode', title, code });
  });

  chrome.runtime.onMessage.addListener((msg) => {
    if (msg.action === 'alert') alert(msg.text);
    });
});
