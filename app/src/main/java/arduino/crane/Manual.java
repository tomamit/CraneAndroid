package arduino.crane;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class Manual extends IntroActivity {

        @Override protected void onCreate(Bundle savedInstanceState){
            setFullscreen(true);
            super.onCreate(savedInstanceState);

            addSlide(new SimpleSlide.Builder()
                    .title("Getting Started")
                    .description(R.string.started)
                    .image(R.drawable.first)
                    .background(R.color.colorPrimary)
                    .backgroundDark(R.color.colorPrimaryDark)
                    .scrollable(true)
                    .build());

            addSlide(new SimpleSlide.Builder()
                    .title("Getting Started")
                    .description(R.string.started)
                    .image(R.drawable.first)
                    .background(R.color.colorPrimary)
                    .backgroundDark(R.color.colorPrimaryDark)
                    .scrollable(true)
                    .build());

            addSlide(new SimpleSlide.Builder()
                    .title("Connecting")
                    .description(R.string.connect)
                    .image(R.drawable.connect)
                    .background(R.color.white)
                    .backgroundDark(R.color.whitedark)
                    .scrollable(true)
                    .build());

            addSlide(new SimpleSlide.Builder()
                    .title("Automatic Control")
                    .description(R.string.auto)
                    .image(R.drawable.auto)
                    .background(R.color.colorAccent)
                    .backgroundDark(R.color.colorAccentDark)
                    .scrollable(true)
                    .build());

            addSlide(new SimpleSlide.Builder()
                    .title("Set Up is Needed")
                    .description(R.string.setup)
                    .image(R.drawable.setuppic)
                    .background(R.color.red)
                    .backgroundDark(R.color.redDark)
                    .scrollable(true)
                    .build());

            addSlide(new SimpleSlide.Builder()
                    .title("Manual Control")
                    .description(R.string.manual)
                    .image(R.drawable.manual)
                    .background(R.color.cyan)
                    .backgroundDark(R.color.cyanDark)
                    .scrollable(true)
                    .build());

            addSlide(new SimpleSlide.Builder()
                    .title("That's All!!")
                    .description(R.string.last)
                    .image(R.drawable.last)
                    .background(R.color.blue)
                    .backgroundDark(R.color.blueDark)
                    .buttonCtaLabel("Get Started")
                    .buttonCtaClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(Manual.this, Devices.class));
                        }
                    })
                    .scrollable(true)
                    .build());
        }

}


