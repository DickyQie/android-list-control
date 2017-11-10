package com.listviewdeletedemo;

import java.util.List;

/**
 * Created by zhangqie on 2017/8/23.
 */

public class UserInfo {

    private int id;
    private List<Data> datas;
    private boolean checkBox;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }
    public List<Data> getDatas() {
        return datas;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }
    public boolean isCheckBox() {
        return checkBox;
    }
    class Data{
        String name;
        String age;
        boolean checkBox;

        public boolean isCheckBox() {
            return checkBox;
        }

        public void setCheckBox(boolean checkBox) {
            this.checkBox = checkBox;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

}
