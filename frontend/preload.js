
const { contextBridge, ipcRenderer } = require("electron");
console.log("PRELOAD LOADED")
contextBridge.exposeInMainWorld("backend", {
    getNovels: () => ipcRenderer.invoke("get-novels"),
    addNovel: (novel) => ipcRenderer.invoke("add-novel", novel),
    save: () => ipcRenderer.invoke("save"),
    load: () => ipcRenderer.invoke("load")
});
