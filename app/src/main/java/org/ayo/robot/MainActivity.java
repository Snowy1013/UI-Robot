package org.ayo.robot;

import android.os.Bundle;

import org.ayo.sample.menu.Leaf;
import org.ayo.sample.menu.MainPagerActivity;
import org.ayo.sample.menu.Menu;
import org.ayo.sample.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MainPagerActivity {

    private List<Menu> menus;

    @Override
    public List<Menu> getMenus() {
        return menus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void init(){
        menus = new ArrayList<Menu>();

        ///--------------------------菜单1：View
        Menu m1 = new Menu("Canvas", R.drawable.weixin_normal, R.drawable.weixin_pressed);
        menus.add(m1);
        {
            MenuItem menuItem1 = new MenuItem("图形", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m1.addMenuItem(menuItem1);
            {
                menuItem1.addLeaf(new Leaf("点", "", null));
                menuItem1.addLeaf(new Leaf("线", "", null));
                menuItem1.addLeaf(new Leaf("图形", "", null));
                menuItem1.addLeaf(new Leaf("Path", "", null));
                menuItem1.addLeaf(new Leaf("Bitmap", "", null));
                menuItem1.addLeaf(new Leaf("BitmapMesh", "", null));
                menuItem1.addLeaf(new Leaf("PathEffect", "", null));
            }


            MenuItem menuItem2 = new MenuItem("Clip", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m1.addMenuItem(menuItem2);
            {
                menuItem2.addLeaf(new Leaf("clip rect", "", null));
                menuItem2.addLeaf(new Leaf("clip path", "", null));
                menuItem2.addLeaf(new Leaf("clip region", "", null));
            }


            MenuItem menuItem3 = new MenuItem("图层变换", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m1.addMenuItem(menuItem3);
            {
                menuItem3.addLeaf(new Leaf("平移", "", null));
                menuItem3.addLeaf(new Leaf("缩放", "", null));
                menuItem3.addLeaf(new Leaf("旋转", "", null));
                menuItem3.addLeaf(new Leaf("自己配置Matrix", "", null));
            }
        }

        ///--------------------------菜单1：开源
        Menu m3 = new Menu("Paint", R.drawable.find_normal, R.drawable.find_pressed);
        menus.add(m3);
        {
            MenuItem menuItem = new MenuItem("ColorFilter", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("ColorMatrixColorFilter", "", null));
                menuItem.addLeaf(new Leaf("LightingColorFilter", "", null));
                menuItem.addLeaf(new Leaf("PorterDuffColorFilter", "", null));
            }

            menuItem = new MenuItem("Xfermode", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("图形混合", "", null));
            }

            menuItem = new MenuItem("Shader", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("BitmapShader", "", null));
                menuItem.addLeaf(new Leaf("渐变Shader", "", null));
            }

            menuItem = new MenuItem("MaskFilter", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("遮罩", "", null));
            }


            menuItem = new MenuItem("字体", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("遮罩", "", null));
            }
        }

        ///--------------------------菜单1：开源
        m3 = new Menu("其他", R.drawable.find_normal, R.drawable.find_pressed);
        menus.add(m3);
        {
            MenuItem menuItem = new MenuItem("Drawable", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("自定义Drawable", "", null));
            }

            menuItem = new MenuItem("SurfaceView", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("用法", "", null));
            }

            menuItem = new MenuItem("TextureView", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("用法", "", null));
            }

        }

        ///--------------------------菜单1：开源
        m3 = new Menu("Bitmap", R.drawable.find_normal, R.drawable.find_pressed);
        menus.add(m3);
        {
            MenuItem menuItem = new MenuItem("Bitmap", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("解析", "", null));
                menuItem.addLeaf(new Leaf("压缩", "", null));
                menuItem.addLeaf(new Leaf("手势缩放", "", null));
                menuItem.addLeaf(new Leaf("剪切", "", null));
                menuItem.addLeaf(new Leaf("合并", "", null));
            }
        }

        ///--------------------------菜单1：开源
        m3 = new Menu("多媒体", R.drawable.find_normal, R.drawable.find_pressed);
        menus.add(m3);
        {
            MenuItem menuItem = new MenuItem("照相", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("照相", "", null));
                menuItem.addLeaf(new Leaf("滤镜", "", null));
            }

            menuItem = new MenuItem("视频", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("录视频", "", null));
                menuItem.addLeaf(new Leaf("视频滤镜", "", null));
                menuItem.addLeaf(new Leaf("视频编码", "", null));
                menuItem.addLeaf(new Leaf("流媒体", "", null));
            }

            menuItem = new MenuItem("音频", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m3.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("录音", "", null));
                menuItem.addLeaf(new Leaf("编解码", "", null));
                menuItem.addLeaf(new Leaf("音乐播放器", "", null));
            }
        }

    }
}
