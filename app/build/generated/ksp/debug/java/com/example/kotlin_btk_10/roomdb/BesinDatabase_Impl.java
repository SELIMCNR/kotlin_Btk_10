package com.example.kotlin_btk_10.roomdb;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class BesinDatabase_Impl extends BesinDatabase {
  private volatile BesinDAO _besinDAO;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `Besindata` (`isim` TEXT, `kalori` TEXT, `karbonhidrat` TEXT, `protein` TEXT, `yag` TEXT, `gorsel` TEXT, `uuid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b6db2417b299a3349e7c7b49f32f7651')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `Besindata`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsBesindata = new HashMap<String, TableInfo.Column>(7);
        _columnsBesindata.put("isim", new TableInfo.Column("isim", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBesindata.put("kalori", new TableInfo.Column("kalori", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBesindata.put("karbonhidrat", new TableInfo.Column("karbonhidrat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBesindata.put("protein", new TableInfo.Column("protein", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBesindata.put("yag", new TableInfo.Column("yag", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBesindata.put("gorsel", new TableInfo.Column("gorsel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBesindata.put("uuid", new TableInfo.Column("uuid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBesindata = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBesindata = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBesindata = new TableInfo("Besindata", _columnsBesindata, _foreignKeysBesindata, _indicesBesindata);
        final TableInfo _existingBesindata = TableInfo.read(db, "Besindata");
        if (!_infoBesindata.equals(_existingBesindata)) {
          return new RoomOpenHelper.ValidationResult(false, "Besindata(com.example.kotlin_btk_10.model.Besindata).\n"
                  + " Expected:\n" + _infoBesindata + "\n"
                  + " Found:\n" + _existingBesindata);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "b6db2417b299a3349e7c7b49f32f7651", "840cd1cfe335a4b2a5d12a8b7511c0c8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Besindata");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Besindata`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(BesinDAO.class, BesinDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public BesinDAO besinDao() {
    if (_besinDAO != null) {
      return _besinDAO;
    } else {
      synchronized(this) {
        if(_besinDAO == null) {
          _besinDAO = new BesinDAO_Impl(this);
        }
        return _besinDAO;
      }
    }
  }
}
