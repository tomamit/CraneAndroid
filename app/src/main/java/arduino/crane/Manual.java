package arduino.crane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class Manual extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        setFullscreen(true);
        setFinishEnabled(false);

        addSlide(new SimpleSlide.Builder()
                .title(R.string.title_material_motion)
                .description(R.string.description_material_motion)
                .image(R.drawable.art_material_motion)
                .background(R.color.color_material_motion)
                .backgroundDark(R.color.color_dark_material_motion)
                .scrollable(scrollable)
                .build());
    }
}
