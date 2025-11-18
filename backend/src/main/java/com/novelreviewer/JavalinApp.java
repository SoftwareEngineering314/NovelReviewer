package com.novelreviewer;
import com.novelreviewer.model.Novel;
import io.javalin.Javalin;
import com.novelreviewer.service.LibraryService;

public class JavalinApp {
    public static void main(String [] args){
        LibraryService library = new LibraryService();
        Javalin app = Javalin.create().start(7000);
        app.get("/novels", ctx -> {
            ctx.json(library.getLibrary().getNovels());
        });
        app.post("/novels", ctx -> {
            Novel novel = ctx.bodyAsClass(Novel.class);
            library.addNovel(novel.getTitle(), novel.getAuthor(), novel.getChapters(), novel.getRating());
            ctx.status(201);
        });
        app.post("/save", ctx -> {
            library.saveLibrary();
            ctx.result("Saved");
        });
        app.post("/load", ctx -> {
            library.loadLibrary();
            ctx.result("Loaded");
        });

    }
}
