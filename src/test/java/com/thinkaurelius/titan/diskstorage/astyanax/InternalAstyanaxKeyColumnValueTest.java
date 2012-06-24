package com.thinkaurelius.titan.diskstorage.astyanax;

import org.junit.BeforeClass;

import com.thinkaurelius.titan.StorageSetup;
import com.thinkaurelius.titan.diskstorage.KeyColumnValueStoreTest;
import com.thinkaurelius.titan.diskstorage.StorageManager;
import com.thinkaurelius.titan.diskstorage.cassandra.CassandraDaemonWrapper;
import com.thinkaurelius.titan.testutil.CassandraUtil;

public class InternalAstyanaxKeyColumnValueTest extends KeyColumnValueStoreTest {

	@BeforeClass
	public static void startCassandra() {
    	CassandraDaemonWrapper.start(StorageSetup.cassandraYamlPath);
	}
	
    @Override
    public StorageManager openStorageManager() {
        return new AstyanaxStorageManager(StorageSetup.getLocalStorageConfiguration());
    }

    
	@Override
	public void cleanUp() {
		CassandraUtil.dropKeyspace(AstyanaxStorageManager.KEYSPACE_DEFAULT);
	}
}
