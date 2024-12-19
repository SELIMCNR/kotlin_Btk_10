package com.example.kotlin_btk_10.roomdb;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.kotlin_btk_10.model.Besindata;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class BesinDAO_Impl implements BesinDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Besindata> __insertionAdapterOfBesindata;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllBesin;

  public BesinDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBesindata = new EntityInsertionAdapter<Besindata>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Besindata` (`isim`,`kalori`,`karbonhidrat`,`protein`,`yag`,`gorsel`,`uuid`) VALUES (?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Besindata entity) {
        if (entity.getIsim() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getIsim());
        }
        if (entity.getKalori() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getKalori());
        }
        if (entity.getKarbonhidrat() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getKarbonhidrat());
        }
        if (entity.getProtein() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getProtein());
        }
        if (entity.getYag() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getYag());
        }
        if (entity.getGorsel() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getGorsel());
        }
        statement.bindLong(7, entity.getUuid());
      }
    };
    this.__preparedStmtOfDeleteAllBesin = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM Besindata";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final Besindata[] besin,
      final Continuation<? super List<Long>> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<List<Long>>() {
      @Override
      @NonNull
      public List<Long> call() throws Exception {
        __db.beginTransaction();
        try {
          final List<Long> _result = __insertionAdapterOfBesindata.insertAndReturnIdsList(besin);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllBesin(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllBesin.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllBesin.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object gettAllBesin(final Continuation<? super List<Besindata>> $completion) {
    final String _sql = "SELECT * FROM  Besindata";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Besindata>>() {
      @Override
      @NonNull
      public List<Besindata> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIsim = CursorUtil.getColumnIndexOrThrow(_cursor, "isim");
          final int _cursorIndexOfKalori = CursorUtil.getColumnIndexOrThrow(_cursor, "kalori");
          final int _cursorIndexOfKarbonhidrat = CursorUtil.getColumnIndexOrThrow(_cursor, "karbonhidrat");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfYag = CursorUtil.getColumnIndexOrThrow(_cursor, "yag");
          final int _cursorIndexOfGorsel = CursorUtil.getColumnIndexOrThrow(_cursor, "gorsel");
          final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
          final List<Besindata> _result = new ArrayList<Besindata>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Besindata _item;
            final String _tmpIsim;
            if (_cursor.isNull(_cursorIndexOfIsim)) {
              _tmpIsim = null;
            } else {
              _tmpIsim = _cursor.getString(_cursorIndexOfIsim);
            }
            final String _tmpKalori;
            if (_cursor.isNull(_cursorIndexOfKalori)) {
              _tmpKalori = null;
            } else {
              _tmpKalori = _cursor.getString(_cursorIndexOfKalori);
            }
            final String _tmpKarbonhidrat;
            if (_cursor.isNull(_cursorIndexOfKarbonhidrat)) {
              _tmpKarbonhidrat = null;
            } else {
              _tmpKarbonhidrat = _cursor.getString(_cursorIndexOfKarbonhidrat);
            }
            final String _tmpProtein;
            if (_cursor.isNull(_cursorIndexOfProtein)) {
              _tmpProtein = null;
            } else {
              _tmpProtein = _cursor.getString(_cursorIndexOfProtein);
            }
            final String _tmpYag;
            if (_cursor.isNull(_cursorIndexOfYag)) {
              _tmpYag = null;
            } else {
              _tmpYag = _cursor.getString(_cursorIndexOfYag);
            }
            final String _tmpGorsel;
            if (_cursor.isNull(_cursorIndexOfGorsel)) {
              _tmpGorsel = null;
            } else {
              _tmpGorsel = _cursor.getString(_cursorIndexOfGorsel);
            }
            _item = new Besindata(_tmpIsim,_tmpKalori,_tmpKarbonhidrat,_tmpProtein,_tmpYag,_tmpGorsel);
            final int _tmpUuid;
            _tmpUuid = _cursor.getInt(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getBesin(final int besinId, final Continuation<? super Besindata> $completion) {
    final String _sql = "SELECT * FROM Besindata WHERE uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, besinId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Besindata>() {
      @Override
      @NonNull
      public Besindata call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIsim = CursorUtil.getColumnIndexOrThrow(_cursor, "isim");
          final int _cursorIndexOfKalori = CursorUtil.getColumnIndexOrThrow(_cursor, "kalori");
          final int _cursorIndexOfKarbonhidrat = CursorUtil.getColumnIndexOrThrow(_cursor, "karbonhidrat");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfYag = CursorUtil.getColumnIndexOrThrow(_cursor, "yag");
          final int _cursorIndexOfGorsel = CursorUtil.getColumnIndexOrThrow(_cursor, "gorsel");
          final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
          final Besindata _result;
          if (_cursor.moveToFirst()) {
            final String _tmpIsim;
            if (_cursor.isNull(_cursorIndexOfIsim)) {
              _tmpIsim = null;
            } else {
              _tmpIsim = _cursor.getString(_cursorIndexOfIsim);
            }
            final String _tmpKalori;
            if (_cursor.isNull(_cursorIndexOfKalori)) {
              _tmpKalori = null;
            } else {
              _tmpKalori = _cursor.getString(_cursorIndexOfKalori);
            }
            final String _tmpKarbonhidrat;
            if (_cursor.isNull(_cursorIndexOfKarbonhidrat)) {
              _tmpKarbonhidrat = null;
            } else {
              _tmpKarbonhidrat = _cursor.getString(_cursorIndexOfKarbonhidrat);
            }
            final String _tmpProtein;
            if (_cursor.isNull(_cursorIndexOfProtein)) {
              _tmpProtein = null;
            } else {
              _tmpProtein = _cursor.getString(_cursorIndexOfProtein);
            }
            final String _tmpYag;
            if (_cursor.isNull(_cursorIndexOfYag)) {
              _tmpYag = null;
            } else {
              _tmpYag = _cursor.getString(_cursorIndexOfYag);
            }
            final String _tmpGorsel;
            if (_cursor.isNull(_cursorIndexOfGorsel)) {
              _tmpGorsel = null;
            } else {
              _tmpGorsel = _cursor.getString(_cursorIndexOfGorsel);
            }
            _result = new Besindata(_tmpIsim,_tmpKalori,_tmpKarbonhidrat,_tmpProtein,_tmpYag,_tmpGorsel);
            final int _tmpUuid;
            _tmpUuid = _cursor.getInt(_cursorIndexOfUuid);
            _result.setUuid(_tmpUuid);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
