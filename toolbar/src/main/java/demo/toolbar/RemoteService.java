package demo.toolbar;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Johnny on 2016/9/21.
 */
public class RemoteService extends Service {
	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
