package com.s11k.apps.bataillecorse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.s11k.apps.bataillecorse.Controller.GameController;
import com.s11k.apps.bataillecorse.Model.Card;
import com.s11k.apps.bataillecorse.Model.Player;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button playerAButton = (Button)findViewById(R.id.playerAPlayButton);
        Button playerBButton = (Button)findViewById(R.id.playerBPlayButton);

        final TextView currentCardText = (TextView)findViewById(R.id.currentPlay);

        playerAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player playerA = GameController.getInstance().getPlayersList().get(0);
                if(playerA != null) {
                    Card c = GameController.getInstance().playCard(playerA);
                    if(c != null){
                        System.out.println(c.toString());
                        currentCardText.setText(c.getLabel());
                    }
                }
            }
        });

        playerBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player playerB = GameController.getInstance().getPlayersList().get(1);
                if(playerB != null) {
                    GameController.getInstance().playCard(playerB);
                }
            }
        });
    }



    // Gestion de l'action bar ---------------------------------------------------------------------

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.in_game_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_quit:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
