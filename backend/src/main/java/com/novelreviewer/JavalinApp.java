package com.novelreviewer;
import com.google.gson.reflect.TypeToken;
import com.novelreviewer.model.Novel;
import io.javalin.Javalin;
import com.novelreviewer.service.LibraryService;
import java.util.List;


public class JavalinApp {
    public static void main(String [] args){
        LibraryService library = new LibraryService();
        Javalin app = Javalin.create().start(7000);
        app.get("/novels", ctx -> {
            ctx.json(library.getLibrary().getNovelList());
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
        app.post("/update", ctx -> {
            List<Novel> updatedList = ctx.bodyAsClass(new TypeToken<List<Novel>>() {}.getType());
            library.setNovels(updatedList);
            ctx.status(201);
        });

    }
}
