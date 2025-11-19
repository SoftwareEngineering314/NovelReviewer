
const loadBtn = document.getElementById("loadBtn");
const addNvl = document.getElementById("addNvl");
const editNvl = document.getElementById("editNvl");
const novelsID = document.getElementById("novels");
const titleInput = document.getElementById("titleInput");
const authorInput = document.getElementById("authorInput");
const chapterInput = document.getElementById("chapterInput");
const ratingInput = document.getElementById("ratingInput");
const saveBtn = document.getElementById("saveBtn");
const trashIcons = document.querySelectorAll(".novels");


editNvl.addEventListener("click", (e) => {
    novelsID.contentEditable = "true";
})
saveBtn.addEventListener("click", async() => {
    const rows = [...document.querySelectorAll("#novels tr")];
    const updatedNovels = rows.map(row => {
        const cells = row.querySelectorAll("td");
        return {
            title: cells[0].textContent,
            author: cells[1].textContent,
            chapters: cells[2].textContent,
            rating: cells[3].textContent
        };
    });
    await window.backend.setNovels(updatedNovels);
    await window.backend.save();
    novelsID.contentEditable = "false";
    populateNovels();

})
loadBtn.addEventListener("click", () => {
    console.log("Load button clicked!");

    window.backend.load()
        .then(() => window.backend.getNovels())
        .then(novels => {
            console.log("Received novels:", novels);
        })
        .catch(err => console.error("Error:", err));
});
document.addEventListener("click", async (e) => {
    if (e.target.classList.contains("deleteBtn")) {
        const row = e.target.closest("tr");
        const id = row.id;
        console.log("Deleting:", id);
        row.remove();
        const novels = await window.backend.getNovels();
        const updated = novels.filter(n => n.title !== id);
        await window.backend.setNovels(updated);
        await window.backend.save();
    }
});
addNvl.addEventListener("click", (e) => {
    console.log("Add novel button clicked!")
    addNovel()
        .then(populateNovels)
        .catch(err => console.error("Error:", err));
    });


async function populateNovels() {
    const novels = await window.backend.getNovels();

    const tableBody = document.getElementById("novels");
    tableBody.innerHTML = "";

    novels.forEach(novel => {
        const row = document.createElement("tr");
        row.id = novel.title;

        row.innerHTML = `
        <td class="titleCell">
            ${novel.title}
            <button class="deleteBtn">🗑</button>
        </td>
        <td>${novel.author}</td>
        <td>${novel.chapters}</td>
        <td>${novel.rating}</td>
    `;

        tableBody.appendChild(row);
    });
}



    async function addNovel() {
        let title = titleInput.value;
        let author = authorInput.value;
        let chapters = chapterInput.value;
        let rating = ratingInput.value;
        const novel = {title, author, chapters, rating};
        await window.backend.addNovel(novel);
        await window.backend.save(); // done so any chapters added are immediately saved in case of crashes
        titleInput.value = "";
        authorInput.value = "";
        chapterInput.value = "";
        ratingInput.value = "";

    }

    window.addEventListener("DOMContentLoaded", () => {
        window.backend.load()
        populateNovels();
    });

