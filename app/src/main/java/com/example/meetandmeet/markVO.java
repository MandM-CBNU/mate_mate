package com.example.meetandmeet;
/// 코드 작성자 2020039017 임수연 ///
public class markVO{
    int imgResId;
    String name;
    String hintId;
    String markbtn;

    //화면에 표시될 문자열 초기화
    public markVO(int imgResId, String name,String hintId,String markbtn) {
        this.imgResId = imgResId;
        this.name = name;
        this.hintId=hintId;
        this.markbtn=markbtn;
    }
    public boolean getSelected()
    {
        return Boolean.parseBoolean(markbtn);
    }

    public void setSelected(boolean selected)
    {
        markbtn = String.valueOf(selected);
    }
}
