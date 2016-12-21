package com.example.mashizhao.jardemo;

import android.content.Context;

/**
 * Created by MaShiZhao on 2016/11/8.
 */
public class ParentResource {

    private static ParentResource myInstance = null;
    private static Context mContext;

    public static void init(Context context){
        mContext = context;
    }

    public static ParentResource getInstance(){
        if (myInstance == null) {
            synchronized (ParentResource.class){
                if (myInstance == null) {
                    myInstance = new ParentResource();
                }
            }
        }
        return myInstance;
    }

    // 通过id获取 获取主工程的资源
    public int getResourceByName(String className, String resName) {
        if (mContext == null) {
            return 0;
        }
        String packageName = mContext.getPackageName();
        int id = 0;
        try {
            Class r = Class.forName(packageName + ".R");
            Class[] classes = r.getClasses();
            Class desireClass = null;
            for (Class cls : classes) {
                if (cls.getName().split("\\$")[1].equals(className)) {
                    desireClass = cls;
                    break;
                }
            }
            if (desireClass != null) {
                id = desireClass.getField(resName).getInt(desireClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * 获取布局的layout
     * @param resName 布局名称
     * @return
     */
    public int getLayoutResource(String resName){
            return getResourceByName("layout",resName);
    }

    /**
     * 获取图片
     * @param resName
     * @return
     */
    public  int getDrawableResource(String resName){
        return getResourceByName("mipmap",resName);
    }

    /**
     * 获取字符串
     * @param resName
     * @return
     */
    public  int getStringResource(String resName){
        return getResourceByName("string",resName);
    }

    /**
     * 获取 findViewById
     * @param resName
     * @return
     */
    public  int getIdResource(String resName){
        return getResourceByName("id",resName);
    }



}
