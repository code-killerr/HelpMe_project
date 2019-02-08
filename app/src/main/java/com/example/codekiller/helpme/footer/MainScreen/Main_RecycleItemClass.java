package com.example.codekiller.helpme.footer.MainScreen;

public class Main_RecycleItemClass {
    private int memberImage;
    private int[] questionImage;
    private String searchText;
    private String memberIntroduce;
    private String questionTitle;
    private String questionDescribe;
    public Main_RecycleItemClass(String search){
        searchText = search;
    }
    public Main_RecycleItemClass(String memberIntro,int memberPic){
        memberIntroduce = memberIntro;
        memberImage = memberPic;
    }
    public Main_RecycleItemClass(String questionTit,String questionDes){
        questionTitle = questionTit;
        questionDescribe = questionDes;
    }
    public Main_RecycleItemClass(String questionTit,String questionDes,int[] questionImg){
        questionTitle = questionTit;
        questionDescribe = questionDes;
        questionImage = questionImg;
    }
    //初始化需要的变量
    public int getMemberImage() {
        return memberImage;
    }

    public String getMemberIntroduce() {
        return memberIntroduce;
    }

    public String getQuestionDescribe() {
        return questionDescribe;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public int[] getQuestionImage() {
        return questionImage;
    }

    public String getSearchText() {
        return searchText;
    }
    //获取数值

}
