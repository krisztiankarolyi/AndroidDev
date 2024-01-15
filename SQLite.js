//SQLite usage
//1 .Create a contract class that defines the structure of your database, including table names and column names. This is typically done using the BaseColumns interface.
  public final class MyDatabaseContract {
    private MyDatabaseContract() {}

    public static class MyTable implements BaseColumns {
        public static final String TABLE_NAME = "my_table";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CONTENT = "content";
    }
}
// 2. Create a class that extends SQLiteOpenHelper to manage database creation and version management
public class MyDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyDatabase.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MyDatabaseContract.MyTable.TABLE_NAME + " (" +
                    MyDatabaseContract.MyTable._ID + " INTEGER PRIMARY KEY," +
                    MyDatabaseContract.MyTable.COLUMN_NAME_TITLE + " TEXT," +
                    MyDatabaseContract.MyTable.COLUMN_NAME_CONTENT + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MyDatabaseContract.MyTable.TABLE_NAME;

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}


//3. Create methods inside MyDbHelper  to perform CRUD operations. For example, to insert data:
public long insertData(String title, String content) {
    SQLiteDatabase db = getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(MyDatabaseContract.MyTable.COLUMN_NAME_TITLE, title);
    values.put(MyDatabaseContract.MyTable.COLUMN_NAME_CONTENT, content);

    return db.insert(MyDatabaseContract.MyTable.TABLE_NAME, null, values);
}

//4. 5. Use the Database Helper in Your Activity or Fragment:
//In your activity or fragment, create an instance of your MyDbHelper and use it to perform database operations.
MyDbHelper dbHelper = new MyDbHelper(this);
long newRowId = dbHelper.insertData("Title", "Content");


//MyDbHelper.deleteData()
public int deleteData(long id) {
    SQLiteDatabase db = getWritableDatabase();

    String selection = MyDatabaseContract.MyTable._ID + " = ?";
    String[] selectionArgs = { String.valueOf(id) };

    return db.delete(
        MyDatabaseContract.MyTable.TABLE_NAME,
        selection,
        selectionArgs
    );
}

//5. MyDbHelper.updateData() 
public int updateData(long id, String newTitle, String newContent) {
    SQLiteDatabase db = getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(MyDatabaseContract.MyTable.COLUMN_NAME_TITLE, newTitle);
    values.put(MyDatabaseContract.MyTable.COLUMN_NAME_CONTENT, newContent);

    String selection = MyDatabaseContract.MyTable._ID + " = ?";
    String[] selectionArgs = { String.valueOf(id) };

    return db.update(
        MyDatabaseContract.MyTable.TABLE_NAME,
        values,
        selection,
        selectionArgs
    );
}

//használat
MyDbHelper dbHelper = new MyDbHelper(this);
// Törlés példa
int deletedRows = dbHelper.deleteData(1); // Törölje az azonosítóval 1 rendelkező rekordot
// Frissítés példa
int updatedRows = dbHelper.updateData(2, "New Title", "New Content"); // Frissítse az azonosítóval 2 rendelkező rekordot
