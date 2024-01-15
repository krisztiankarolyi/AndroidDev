// Példa: érték mentése a SharedPreferences-ben
SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.putString("username", "JohnDoe");
editor.putInt("score", 100);
editor.apply();

//2. Értékek olvasása a SharedPreferences-ből:
// Példa: érték olvasása a SharedPreferences-ből
SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
String username = sharedPreferences.getString("username", "DefaultUsername");
int score = sharedPreferences.getInt("score", 0);

//SaveInstance
public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNT = "count";
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            // Az állapot visszaállítása a Bundle objektumból
            count = savedInstanceState.getInt(KEY_COUNT, 0);
            updateCount();
        }

        // Egy gomb eseménykezelője
        Button incrementButton = findViewById(R.id.incrementButton);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                updateCount();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Az állapot mentése a Bundle objektumba
        outState.putInt(KEY_COUNT, count);
    }

    private void updateCount() {
        // Az állapot frissítése a felhasználói felületen
        TextView countTextView = findViewById(R.id.countTextView);
        countTextView.setText(String.valueOf(count));
    }
}
