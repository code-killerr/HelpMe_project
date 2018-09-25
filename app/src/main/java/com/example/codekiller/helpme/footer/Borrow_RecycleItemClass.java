package com.example.codekiller.helpme.footer;

public class Borrow_RecycleItemClass {
    private String title;
    private String introduce;
    private int[] image;
    public Borrow_RecycleItemClass(String title,String introduce,int[] image){
        this.title = title;
        this.introduce = introduce;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int[] getImage() {
        return image;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void AllItem(String title,String introduce,int[] image) {
        this.image = image;
        this.introduce = introduce;
        this.title = title;
    }
}
