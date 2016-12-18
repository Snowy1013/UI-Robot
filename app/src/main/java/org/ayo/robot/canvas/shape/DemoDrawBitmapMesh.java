package org.ayo.robot.canvas.shape;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.R;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoDrawBitmapMesh extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_bitmap_mesh);

        final BitmapMeshView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);



        final Button btn_change = findViewById(R.id.btn_change);
        btn_change.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currentPostion++;
                if(currentPostion >= providers.length){
                    currentPostion = 0;
                }
                BitmapMeshView.VertsProvider provider = providers[currentPostion];
                btn_change.setText("切换（当前：" + provider.getName() + ")");

                shapeView.setVertsPrivider(provider);
            }
        });
    }

    final BitmapMeshView.VertsProvider[] providers = {
            new BitmapMeshVertsProviders.SkepProvider(),
            new BitmapMeshVertsProviders.ReadingGlassesProvider(),

    };

    int currentPostion = -1;
}

