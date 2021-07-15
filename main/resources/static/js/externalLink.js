document.addEventListener('click', function (ev) {
    if (!ev.target.classList.contains('externalLink')) return;

    alert("This link will open an external site in a new tab.")
})
