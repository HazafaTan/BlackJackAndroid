package com.example.blackjackgame;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import  java.util.ArrayList;

public class GAME extends AppCompatActivity    implements LoseDialog.LoseExampleDialogListner, WinDialog.ExampleDialogListener {
    //initialize all the ArrayLists as a private varaible
    private static ArrayList<cards> Deck = new ArrayList<cards>();
    private static ArrayList<cards> PlayerHand = new ArrayList<cards>();
    private static ArrayList<cards> DealerHand = new ArrayList<cards>();
    //initilizes a k variable used for counter
    private static int k = 0;
    private static int move =1;//creates an int variable to count the amount of moves
    private boolean isWin;//creates a boolean value of whether the person won or not
    public static int DealerValue =0;//creates a int variable for the score of Dealer
    private static int counter =1;//creates a counter variable to count for run values
    public static   int PlayerValue =0;//creates an int variable for the score of the Player
    private static boolean IsHit = false;
    Button Stand;//initilizes the button 'Stand' as a Button
    //initializes all the positions of the pictures as an ImageView
    ImageView firstImage, secondImage, thirdImage, fourthImage, fifthImage, sixthImage, cpuImage , cpuImage2, cpuImage3, cpuImage4, cpuImage5, cpuImage6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Deck.clear();//clears the Deck ArrayList
        PlayerHand.clear();//clears the PLayerHand ArrayList
        DealerHand.clear();//clears the DealerHand ArrayList
        createDeck();//runs back to createDeck() method that will generate random cards onto the deck
        PlayerValue=0;//sets the PlayerValue as 0
        counter =1;//sets the counter value as 1
        DealerValue =0;//sets the Dealer Value as 0
        move=1;//sets the move number as 1
        k=0;//sets the counter, k as 0

        //inputs all the ImageView files onto its correct positions
        firstImage = (ImageView) findViewById(R.id.firstImage);
        secondImage =  (ImageView) findViewById(R.id.secondImage);
        thirdImage = (ImageView) findViewById(R.id.thirdImage);
        fourthImage = (ImageView) findViewById(R.id.fourthImage);
        fifthImage = (ImageView) findViewById(R.id.fifthImage);
        sixthImage = (ImageView) findViewById(R.id.sixthImage);
        cpuImage = (ImageView) findViewById(R.id.cpuImage);
        cpuImage2 = (ImageView) findViewById(R.id.cpuImage2);
        cpuImage3 = (ImageView) findViewById(R.id.cpuImage3);
        cpuImage4 = (ImageView) findViewById(R.id.cpuImage4);
        cpuImage5 = (ImageView) findViewById(R.id.cpuImage5);
        cpuImage6 = (ImageView) findViewById(R.id.cpuImage6);

        Stand = findViewById(R.id.Stand);
        Stand.setClickable(false);
        Stand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //system runs while loop to check if dealer score is over 21
                while (DealerValue < 17) {
                    //creates a new cards deck that inputs in new card value
                    cards DeckHitCpu = Deck.get(Hit());
                    Deck.remove(DeckHitCpu);//from the overall Deck, removes the card choses
                    DealerHand.add(DeckHitCpu);//adds the card generated onto the DealerHand
                    counter++;//adds one to the counter

                    //system checks for which move is being played and inputs images in accordingly
                    if (counter == 2) {
                        assignImages(DeckHitCpu.getIntNum(), cpuImage);
                    } else if (counter == 3) {
                        assignImages(DeckHitCpu.getIntNum(), cpuImage3);
                    } else if (counter == 4) {
                        assignImages(DeckHitCpu.getIntNum(), cpuImage4);
                    } else if (counter == 5) {
                        assignImages(DeckHitCpu.getIntNum(), cpuImage5);
                    } else if (counter == 6) {
                        assignImages(DeckHitCpu.getIntNum(), cpuImage6);
                    }
                    //system checks if the size of the hand of the dealer is 2
                    if(DealerHand.size()==2 ) {
                        //if so, runs a for loop to go through the hand of the dealer
                        for (int i = 0; i < DealerHand.size(); i++) {
                            //creates a new string value to get the string values of the dealer hand
                            String value = DealerHand.get(i).getValue();
                            //runs a switch case to check what the value is
                            switch (value) {
                                //if the value is aces, adds one
                                case "aces":
                                    DealerValue += 1;

                                    break;
                                case "jack"://of the value is jack add 10
                                    DealerValue += 10;

                                    break;
                                case "queen":
                                    DealerValue += 10; // if the value is queen add 10

                                    break;
                                case "king": // if the value is king add 10
                                    DealerValue += 10;

                                    break;
                                case "2": // if the value is 2 add 2
                                    DealerValue += 2;

                                    break;
                                case "3": // if the value is 3 add 3
                                    DealerValue += 3;

                                    break;
                                case "4": // if the value is 4 add 4
                                    DealerValue += 4;

                                    break;
                                case "5": // if the value is 5 add 5
                                    DealerValue += 5;

                                    break;
                                case "6": // if the value is 6 add 6
                                    DealerValue += 6;

                                    break;
                                case "7": // if the value is 7 add 7
                                    DealerValue += 7;

                                    break;
                                case "8": // if the value is 8 add 8
                                    DealerValue += 8;

                                    break;
                                case "9": // if the value is 9 add 9
                                    DealerValue += 9;

                                    break;

                                case "10": // if the value is 10 add 10
                                    DealerValue += 10;

                                    break;
                            }
                        }

                    }else{
                        //creates a new String value to run through end off dealer hand
                        String value = DealerHand.get(DealerHand.size()-1).getValue();
                        //switch value to check what is the value and adds points accordingly
                        switch (value) {
                            case "aces":
                                DealerValue += 1;

                                break;
                            case "jack":
                                DealerValue += 10;

                                break;
                            case "queen":
                                DealerValue += 10;

                                break;
                            case "king":
                                DealerValue += 10;

                                break;
                            case "2":
                                DealerValue += 2;

                                break;
                            case "3":
                                DealerValue += 3;

                                break;
                            case "4":
                                DealerValue += 4;
                                break;
                            case "5":
                                DealerValue += 5;
                                break;
                            case "6":
                                DealerValue += 6;
                                break;
                            case "7":
                                DealerValue += 7;
                                break;
                            case "8":
                                DealerValue += 8;
                                break;
                            case "9":
                                DealerValue += 9;
                                break;

                            case "10":
                                DealerValue += 10;
                                break;
                        }
                    }
                }
                    //win conditions to check who has more points and if any player went above 21
                    if (PlayerValue > DealerValue && PlayerValue <= 21) {
                        isWin = true;
                        FinalSequence();
                    } else if (DealerValue == 21) {
                        isWin = false;
                        FinalSequence();
                    } else if (DealerValue > PlayerValue && DealerValue <= 21) {
                        isWin = false;
                        FinalSequence();
                    } else if (DealerValue > 21) {
                        isWin = true;
                        FinalSequence();
                    }else if (DealerValue == PlayerValue){
                        isWin=true;
                        FinalSequence();
                    }

            }
        });
        Button Button = findViewById(R.id.Button); // hit button
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stand = findViewById(R.id.Stand);
                Stand.setClickable(true);
                //sets the PlayerValue to 0
                PlayerValue=0;
                if (move ==5){
                    isWin = true;
                    FinalSequence();
                }
                //system checks for the move
                if (move ==1){
                    //creates a new card variable with the new value for the Player
               cards DeckHitCPU  = Deck.get(Hit());
               DealerHand.add(DeckHitCPU);//adds new card into deckCPU
                  Deck.remove(DeckHitCPU);//removes the card from the deck
                    cards DeckHit  = Deck.get(Hit());//adds a new card onto the player hand
                    Deck.remove(DeckHit);//removes that card from the deck
                    cards DeckHit2 =Deck.get(Hit());//adds another random card onto cards
                    Deck.remove(DeckHit2);//removes that card from the deck
                    PlayerHand.add(DeckHit);//adds the card onto player
                    PlayerHand.add(DeckHit2);//adds the card onto player
                    //adds images into place
                   assignImages(DeckHitCPU.getIntNum(),cpuImage2);
                    assignImages(DeckHit.getIntNum(), firstImage);
                    assignImages(DeckHit2.getIntNum(), secondImage);
                    move++;//adds one to move
                }else if (move ==2){//system checks if its 2nd turn
                    cards DeckHit = Deck.get(Hit());//creates new random card
                    Deck.remove(DeckHit);//removes card from deck
                    PlayerHand.add(DeckHit);//adds a new card onto the player hand
                    assignImages(DeckHit.getIntNum(), thirdImage);//adds image according to position
                    move++;//adds one to move
                //system checks move value
                }else if (move ==3){
                    cards DeckHit = Deck.get(Hit());//creates new random card
                    PlayerHand.add(DeckHit);//adds a new card onto the player hand
                    Deck.remove(DeckHit);//removes card from deck
                    //adds image according to position
                    assignImages(DeckHit.getIntNum(), fourthImage);
                move++;//adds one to move
                }else if (move ==4){
                    cards DeckHit = Deck.get(Hit());//creates new random card
                    Deck.remove(DeckHit);//removes card from deck
                    PlayerHand.add(DeckHit);//adds a new card onto the player hand
                    //adds image according to position
                    assignImages(DeckHit.getIntNum(), fifthImage);
                    move++;//adds one to move
                } else if (move ==5){//checks value of move
                    cards DeckHit = Deck.get(Hit());//creates new random card
                    Deck.remove(DeckHit);//removes card from deck
                    PlayerHand.add(DeckHit);//adds a new card onto the player hand
                    //adds the image accordingly
                    assignImages(DeckHit.getIntNum(), sixthImage);
                    //adds the image accordingly
                    move++;//adds one to move
                }else{
                    move = 1;//or else, move is just 1
                }
                //for loop to run through the hand of the player
                for (int i = 0; i < PlayerHand.size();i++){
                    //makes a string value to get string playerHand values
                    String value =  PlayerHand.get(i).getValue();
                    //switch case to run through what value player has
                    switch (value){case "aces"://checks for aces and add 1
                         PlayerValue+=1;
                        break;
                        case "jack"://checks for jack and add 10
                           PlayerValue +=10;
                            break;
                        case "queen"://checks for queen and add 10
                           PlayerValue +=10;
                            break;
                        case "king"://checks for king and add 10
                           PlayerValue +=10;
                            break;
                        case "2"://checks for 2 and add 2
                            PlayerValue +=2;
                            break;
                        case "3"://checks for 3 and add 3
                            PlayerValue +=3;
                            break;
                        case "4"://checks for 4 and add 4
                            PlayerValue +=4;
                            break;
                        case "5"://checks for 5 and add 5
                            PlayerValue +=5;
                            break;
                        case "6"://checks for 6 and add 6
                           PlayerValue +=6;
                            break;
                        case "7"://checks for 7 and add 7
                            PlayerValue +=7;
                            break;
                        case "8"://checks for 8 and add 8
                            PlayerValue +=8;
                            break;
                        case "9"://checks for 9 and add 9
                           PlayerValue +=9;
                            break;
                        case "10"://checks for 10 and add 10
                           PlayerValue+=10;
                            break;
                    }
                }
                //system checks if player has more than 21
                if (PlayerValue >21){
                    Stand.performClick();
                    isWin = false;//player loses
                    FinalSequence();//goes to final screen
                }else if (PlayerValue == 21){//or else checks if player has 21
                    Stand.performClick();
                    isWin= true;//player wins
                    FinalSequence();//goes to final screen


                }
            }
        });
    }
    //void method that will restart activity when button on dialog is clicked
    @Override
    public void onRESTARTCLICK() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    //will make the activity fullscreen and no  on screen buttons
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }
    public void FinalSequence(){
        if (isWin ==true){
        WinDialog  winDialog = new WinDialog();
        winDialog.show(getSupportFragmentManager(), "Win Dialog");
        }else{
            LoseDialog loseDialog = new LoseDialog();
            loseDialog.show(getSupportFragmentManager(),"Lose Dialog");
        }


    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
    /*
     *void method that goes back to MainActivity when button is clicked
     */
    public void QuitGame (View view){
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
        startActivity (i);
    }

    /**
     *creates a new Deck by adding the card object into an arrayList
     */
    public static void createDeck() {
        //Initialize String Array that will hold the symbol of each card
        String[] strSymbol = {"clovers","diamonds","hearts", "spades", };
        //Initialize String Array that will hold the value of each card
        String[] strValue = {"10", "2", "3", "4", "5", "6", "7", "8", "9","aces", "jack", "king","queen"};
        //for loop that will run for the amount of different values of cards
        for (int i = 0; i < 13; i++) {
            //nested for loop that will run for length of the value array
            for (int j = 0; j < 4; j++) {
                //initalize a new card and store each component from the arrays into the constructor fields
                cards c = new cards(strValue[i], strSymbol[j], k);
                //increment k, this will give each card a unique number
                k++;
                //add the card to the arrayList, Deck
                Deck.add(c);
            }
        }
    }

    /**
     * Using hit will allow the program to get a random card
     * @return a unique Integer number
     */
    public static int Hit() {
        //declare a double variable that will store the max value which is the ArrayList Size
        double max = Deck.size()-1;
        //Declare a double variable that will store the min value as 0
        double min = 0;
        //declare a variable that will calculate a random number in between the min and max value
        double x = (Math.random() * ((max - min) + 1)) + min;
        //store the double variable as an int by casting the number
        int value = (int) x;
        //return the random number
        return value;
    }

    /**
     * If the user clicks yes, then restart the currenr activity
     */
    @Override
    public void onYESClicked() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    /**
     * Assign images to the each card
     * @param Card the number that will be used to determine what photo will be attached
     * @param image the image location wihin the XML layout
     */
    public void assignImages(int Card, ImageView image){
        //switch case that will set an image resource for each case
        switch (Card){
            case 0:
                image.setImageResource(R.drawable.c10c);
                break;
          case 1:
        image.setImageResource(R.drawable.c10d);
        break;
            case 2:
                image.setImageResource(R.drawable.c10h);
                break;
            case 3:
                image.setImageResource(R.drawable.c10s);
                break;
            case 4:
                image.setImageResource(R.drawable.c2c);
                break;
            case 5:
                image.setImageResource(R.drawable.c2d);
                break;
            case 6:
                image.setImageResource(R.drawable.c2h);
                break;
            case 7:
                image.setImageResource(R.drawable.c2s);
                break;
            case 8:
                image.setImageResource(R.drawable.c3c);
                break;
            case 9:
                image.setImageResource(R.drawable.c3d);
                break;
            case 10:
                image.setImageResource(R.drawable.c3h);
                break;
            case 11:
                image.setImageResource(R.drawable.c3s);
                break;
            case 12:
                image.setImageResource(R.drawable.c4c);
                break;
            case 13:
                image.setImageResource(R.drawable.c4d);
                break;
            case 14:
                image.setImageResource(R.drawable.c4h);
                break;
            case 15:
                image.setImageResource(R.drawable.c4s);
                break;
            case  16:
                image.setImageResource(R.drawable.c5c);
                break;
            case  17:
                image.setImageResource(R.drawable.c5d);
                break;
            case  18:
                image.setImageResource(R.drawable.c5h);
                break;
            case  19:
                image.setImageResource(R.drawable.c5s);
                break;
            case  20:
                image.setImageResource(R.drawable.c6c);
                break;
            case  21:
                image.setImageResource(R.drawable.c6d);
                break;
            case  22:
                image.setImageResource(R.drawable.c6h);
                break;
            case  23:
                image.setImageResource(R.drawable.c6s);
                break;
            case  24:
                image.setImageResource(R.drawable.c7c);
                break;
            case  25:
                image.setImageResource(R.drawable.c7d);
                break;
            case  26:
                image.setImageResource(R.drawable.c7h);
                break;
            case  27:
                image.setImageResource(R.drawable.c7s);
                break;
                case  28:
                image.setImageResource(R.drawable.c8c);
                    break;
            case  29:
                image.setImageResource(R.drawable.c8d);
                break;
            case  30:
                image.setImageResource(R.drawable.c8h);
                break;
            case  31:
                image.setImageResource(R.drawable.c8s);
                break;
            case  32:
                image.setImageResource(R.drawable.c9c);
                break;
            case  33:
                image.setImageResource(R.drawable.c9d);
                break;
            case  34:
                image.setImageResource(R.drawable.c9h);
                break;
            case  35:
                image.setImageResource(R.drawable.c9s);
                break;
            case  36:
                image.setImageResource(R.drawable.cac);
                break;
            case  37:
                image.setImageResource(R.drawable.cad);
                break;
            case  38:
                image.setImageResource(R.drawable.cah);
                break;
            case  39:
                image.setImageResource(R.drawable.cas);
                break;
            case  40:
                image.setImageResource(R.drawable.cjc);
                break;
            case  41:
                image.setImageResource(R.drawable.cjd);
                break;
            case  42:
                image.setImageResource(R.drawable.cjh);
                break;
            case  43:
                image.setImageResource(R.drawable.cjs);
                break;
            case  44:
                image.setImageResource(R.drawable.ckc);
                break;
            case  45:
                image.setImageResource(R.drawable.ckd);
                break;
            case  46:
                image.setImageResource(R.drawable.ckh);
                break;
            case  47:
                image.setImageResource(R.drawable.cks);
                break;
            case  48:
                image.setImageResource(R.drawable.cqc);
                break;
            case  49:
                image.setImageResource(R.drawable.cqd);
                break;
            case  50:
                image.setImageResource(R.drawable.cqh);
                break;
            case  51:
                image.setImageResource(R.drawable.cqs);
                break;
    }
}

}
