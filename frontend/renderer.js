
const loadBtn = document.getElementById("loadBtn");
const addNvl = document.getElementById("addNvl");
const editNvl = document.getElementById("editNvl");
const novelsID = document.getElementById("novels");
const titleInput = document.getElementById("titleInput");
const authorInput = document.getElementById("authorInput");
const chapterInput = document.getElementById("chapterInput");
const ratingInput = document.getElementById("ratingInput");
const saveBtn = document.getElementById("saveBtn");


editNvl.addEventListener("click", (e) => {
    novelsID.contentEditable = "true";
    saveBtn.addEventListener("click", (e) => {
        window.backend.save()
            .then((populateNovels))
            .then((novelsID.contentEditable = "false"))
    })

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

addNvl.addEventListener("click", (e) => {
    console.log("Add novel button clicked!")
    addNovel()
        .then(populateNovels)
        .catch(err => console.error("Error:", err));
    });

async function populateNovels() {
    const data = await window.backend.getNovels();

    console.log("Received:", data);


    const novels = Object.values(data);

    const tableBody = document.getElementById("novels");
    tableBody.innerHTML = "";

    novels.forEach(rowData => {
        const row = document.createElement("tr");

        for (const key in rowData) {
            const cell = document.createElement("td");
            cell.textContent = rowData[key];
            row.appendChild(cell);
        }

        tableBody.appendChild(row);
    });
}
async function addNovel(){
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

