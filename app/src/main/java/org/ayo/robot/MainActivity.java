package org.ayo.robot;

import android.os.Bundle;

import org.ayo.robot.canvas.clip.DemoClipPath;
import org.ayo.robot.canvas.clip.DemoClipRect;
import org.ayo.robot.canvas.clip.DemoClipRegion;
import org.ayo.robot.canvas.clip.DemoClipRegionOp;
import org.ayo.robot.canvas.matrix.DemoMatrix;
import org.ayo.robot.canvas.matrix.DemoRotate;
import org.ayo.robot.canvas.matrix.DemoSave;
import org.ayo.robot.canvas.matrix.DemoScale;
import org.ayo.robot.canvas.matrix.DemoSkew;
import org.ayo.robot.canvas.matrix.DemoTranslate;
import org.ayo.robot.canvas.path.DemoDrawPathEffect;
import org.ayo.robot.canvas.shape.DemoDrawARGB;
import org.ayo.robot.canvas.shape.DemoDrawArc;
import org.ayo.robot.canvas.shape.DemoDrawBitmap;
import org.ayo.robot.canvas.shape.DemoDrawBitmapMesh;
import org.ayo.robot.canvas.shape.DemoDrawCircile;
import org.ayo.robot.canvas.shape.DemoDrawColor;
import org.ayo.robot.canvas.shape.DemoDrawLine;
import org.ayo.robot.canvas.shape.DemoDrawOval;
import org.ayo.robot.canvas.shape.DemoDrawPaint;
import org.ayo.robot.canvas.path.DemoDrawPath_arc;
import org.ayo.robot.canvas.path.DemoDrawPath_bezier2;
import org.ayo.robot.canvas.path.DemoDrawPath_bezier3;
import org.ayo.robot.canvas.path.DemoDrawPath_line;
import org.ayo.robot.canvas.shape.DemoDrawPicture;
import org.ayo.robot.canvas.shape.DemoDrawPoint;
import org.ayo.robot.canvas.shape.DemoDrawRect;
import org.ayo.robot.canvas.shape.DemoDrawRoundRect;
import org.ayo.robot.canvas.shape.DemoDrawVertical;
import org.ayo.sample.menu.Leaf;
import org.ayo.sample.menu.MainPagerActivity;
import org.ayo.sample.menu.Menu;
import org.ayo.sample.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MainPagerActivity {

    private static List<Menu> menus;

    @Override
    public List<Menu> getMenus() {
        return menus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);

    }

    private void init(){
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    static{
        menus = new ArrayList<Menu>();

        ///--------------------------菜单1：View
        Menu m1 = new Menu("Canvas", R.drawable.weixin_normal, R.drawable.weixin_pressed);
        menus.add(m1);
        {
            MenuItem menuItem1 = new MenuItem("图形", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m1.addMenuItem(menuItem1);
            {
                menuItem1.addLeaf(new Leaf("draw color", "", DemoDrawColor.class));
                menuItem1.addLeaf(new Leaf("draw argb", "", DemoDrawARGB.class));
                menuItem1.addLeaf(new Leaf("draw paint", "", DemoDrawPaint.class));
                menuItem1.addLeaf(new Leaf("draw Point", "", DemoDrawPoint.class));
                menuItem1.addLeaf(new Leaf("draw Line", "", DemoDrawLine.class));
                menuItem1.addLeaf(new Leaf("draw Rect", "", DemoDrawRect.class));
                menuItem1.addLeaf(new Leaf("draw RoundRect：圆角矩形", "", DemoDrawRoundRect.class));
                menuItem1.addLeaf(new Leaf("draw circle", "", DemoDrawCircile.class));
                menuItem1.addLeaf(new Leaf("draw Oval：椭圆", "", DemoDrawOval.class));
                menuItem1.addLeaf(new Leaf("draw Arc：扇形或圆弧线", "", DemoDrawArc.class));
                menuItem1.addLeaf(new Leaf("draw Path：路径，多边形，曲线", "", DemoDrawPath_line.class));
                menuItem1.addLeaf(new Leaf("draw Bitmap", "", DemoDrawBitmap.class));
                menuItem1.addLeaf(new Leaf("draw Picture", "", DemoDrawPicture.class));
                menuItem1.addLeaf(new Leaf("draw Vertical", "", DemoDrawVertical.class));
            }

            MenuItem menuItem2 = new MenuItem("Path", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m1.addMenuItem(menuItem2);
            {
                menuItem2.addLeaf(new Leaf("lineTo", "", DemoDrawPath_line.class));
                menuItem2.addLeaf(new Leaf("arcTo", "", DemoDrawPath_arc.class));
                menuItem2.addLeaf(new Leaf("quadTo", "", DemoDrawPath_bezier2.class));
                menuItem2.addLeaf(new Leaf("cubicTo", "", DemoDrawPath_bezier3.class));
                menuItem2.addLeaf(new Leaf("add系列方法：添加非连续路径", "", null));
                menuItem2.addLeaf(new Leaf("PathEffect", "", DemoDrawPathEffect.class));
            }

            menuItem2 = new MenuItem("BitmapMesh", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m1.addMenuItem(menuItem2);
            {
                menuItem2.addLeaf(new Leaf("draw BitmapMesh：网格变换", "", DemoDrawBitmapMesh.class));
            }

            menuItem2 = new MenuItem("Clip", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m1.addMenuItem(menuItem2);
            {
                menuItem2.addLeaf(new Leaf("clip rect", "", DemoClipRect.class));
                menuItem2.addLeaf(new Leaf("clip path", "", DemoClipPath.class));
                menuItem2.addLeaf(new Leaf("clip region：已被废弃，因为不支持matrix", "", DemoClipRegion.class));
                menuItem2.addLeaf(new Leaf("clip region op", "", DemoClipRegionOp.class));
            }


            MenuItem menuItem3 = new MenuItem("图层变换", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m1.addMenuItem(menuItem3);
            {
                menuItem3.addLeaf(new Leaf("save和restore", "", DemoSave.class));
                menuItem3.addLeaf(new Leaf("旋转", "", DemoRotate.class));
                menuItem3.addLeaf(new Leaf("平移", "", DemoTranslate.class));
                menuItem3.addLeaf(new Leaf("缩放", "", DemoScale.class));
                menuItem3.addLeaf(new Leaf("错切", "", DemoSkew.class));
                menuItem3.addLeaf(new Leaf("自己配置Matrix", "", DemoMatrix.class));
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
                menuItem.addLeaf(new Leaf("draw text", "", null));
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

//        ///--------------------------菜单1：开源
//        m3 = new Menu("Bitmap", R.drawable.find_normal, R.drawable.find_pressed);
//        menus.add(m3);
//        {
//            MenuItem menuItem = new MenuItem("Bitmap", R.drawable.weixin_normal, R.drawable.weixin_pressed);
//            m3.addMenuItem(menuItem);
//            {
//                menuItem.addLeaf(new Leaf("解析", "", null));
//                menuItem.addLeaf(new Leaf("压缩", "", null));
//                menuItem.addLeaf(new Leaf("手势缩放", "", null));
//                menuItem.addLeaf(new Leaf("剪切", "", null));
//                menuItem.addLeaf(new Leaf("合并", "", null));
//            }
//        }
//
//        ///--------------------------菜单1：开源
//        m3 = new Menu("多媒体", R.drawable.find_normal, R.drawable.find_pressed);
//        menus.add(m3);
//        {
//            MenuItem menuItem = new MenuItem("照相", R.drawable.weixin_normal, R.drawable.weixin_pressed);
//            m3.addMenuItem(menuItem);
//            {
//                menuItem.addLeaf(new Leaf("照相", "", null));
//                menuItem.addLeaf(new Leaf("滤镜", "", null));
//            }
//
//            menuItem = new MenuItem("视频", R.drawable.weixin_normal, R.drawable.weixin_pressed);
//            m3.addMenuItem(menuItem);
//            {
//                menuItem.addLeaf(new Leaf("录视频", "", null));
//                menuItem.addLeaf(new Leaf("视频滤镜", "", null));
//                menuItem.addLeaf(new Leaf("视频编码", "", null));
//                menuItem.addLeaf(new Leaf("流媒体", "", null));
//            }
//
//            menuItem = new MenuItem("音频", R.drawable.weixin_normal, R.drawable.weixin_pressed);
//            m3.addMenuItem(menuItem);
//            {
//                menuItem.addLeaf(new Leaf("录音", "", null));
//                menuItem.addLeaf(new Leaf("编解码", "", null));
//                menuItem.addLeaf(new Leaf("音乐播放器", "", null));
//            }
//        }

    }
}
