
const { app, BrowserWindow, ipcMain } = require("electron");
const path = require("path");

function createWindow() {
    const win = new BrowserWindow({
        width: 800,
        height: 600,
        webPreferences: {
            preload: path.join(__dirname, "preload.js"),
            contextIsolation: true,
            nodeIntegration: false,
            sandbox: false
        }
    });

    //win.webContents.openDevTools();

    return win;
}


app.whenReady().then(() => {
    const win = createWindow();
    win.loadFile(path.join(__dirname, "index.html"))
});

app.on("window-all-closed", () => {
    if (process.platform !== "darwin") app.quit();
});

ipcMain.handle("get-novels", async () => {
    const res = await fetch("http://localhost:7000/novels");
    return res.json();
});

ipcMain.handle("load", async () => {
    const res = await fetch("http://localhost:7000/load", {
        method: "POST",
    });
    return res.text();
})

ipcMain.handle("add-novel", async (event, novel) => {
    const res = await fetch("http://localhost:7000/novels", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(novel)
    });
    return res.status;
});
ipcMain.handle("save", async () => {
    const res = await fetch("http://localhost:7000/save", {
        method: "POST",
    })
    return res.text();
})
