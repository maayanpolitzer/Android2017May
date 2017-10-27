package example.com.gestures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;

public class MainActivity extends AppCompatActivity {

    private ImageView ball;
    private final int BALL_SIZE = 200;
    private boolean draging;
    private float fixX, fixY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   // hides the status bar.
        // hide the action bar from res/values/styles.xml (change DarkActionBar to NoActionBar).

        displayBall();

        /*
        // change ball position:
        ball.setX(400);
        ball.setY(400);
        */


    }

    private void displayBall() {
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.main_layout);

        RelativeLayout.LayoutParams ballParams = new RelativeLayout.LayoutParams(BALL_SIZE, BALL_SIZE);

        ball = new ImageView(this);
        ball.setImageResource(R.drawable.baseball);
        ball.setLayoutParams(ballParams);

        mainLayout.addView(ball);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case ACTION_MOVE:
                if (draging) {
                    ball.setX(event.getX() - fixX);
                    ball.setY(event.getY() - fixY);
                }
                break;

            case ACTION_DOWN:
                if (
                        event.getX() >= ball.getX() &&
                        event.getX() <= ball.getX() + ball.getWidth() &&
                        event.getY() >= ball.getY() &&
                        event.getY() <= ball.getY() + ball.getHeight()
                        ) {
                    fixX = event.getX() - ball.getX();
                    fixY = event.getY() - ball.getY();
                    draging = true;
                }
                break;

            default:
                draging = false;
                fixX = 0;
                fixY = 0;
                break;
        }

        return true;
    }
}
