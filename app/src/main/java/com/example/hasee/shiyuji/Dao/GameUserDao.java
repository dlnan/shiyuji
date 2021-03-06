package com.example.hasee.shiyuji.Dao;

import android.content.Context;
import android.widget.Toast;

import com.example.hasee.shiyuji.DB.GameUser;
import com.example.hasee.shiyuji.Log.LogUtil;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * 该类用来查询数据库中的信息和用户输入的信息是否一致
 */
public class GameUserDao {

    private static final String TAG = "GameUserDao";

    /*
    账号密码注册
     */
    public static void signUp(String userName, String password, final Context context) {
        final GameUser user = new GameUser();
        user.setUsername(userName);
        user.setPassword(password);
        user.signUp(new SaveListener<GameUser>() {
            @Override
            public void done(GameUser gameUser, BmobException e) {
                if (e == null) {
                    Toast.makeText(context, "创建成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "创建失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*
    更新数据
     */
    public static Double upDate() {
        final GameUser user = BmobUser.getCurrentUser(GameUser.class);
        user.setMoney(10000.00);
        user.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    LogUtil.v(TAG, "更新成功" + user.getMoney());
                } else {
                    LogUtil.v(TAG, "更新失败" + e.getMessage());
                }
            }
        });
        return user.getMoney();
    }
}
