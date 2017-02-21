package com.transsion.store.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

import com.transsion.store.FileWatcherListener;

public class FileWatcher implements Runnable {
	private WatchService mWatchService;
	private Map<String, FileWatcherListener> mListeners;
	private Map<WatchKey, Path> mWatchKeys;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FileWatcher(String basePathName) {
		this.mListeners = new HashMap();
		this.mWatchKeys = new HashMap();
		try {
			this.mWatchService = FileSystems.getDefault().newWatchService();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addListener(String fileName, FileWatcherListener listener) {
		File file = new File(fileName);
		if ((this.mListeners != null) && (file.exists())) {
			if (file.isDirectory()) {
				Path path = Paths.get(file.getPath(), new String[0]);
				try {
					WatchKey key = path
							.register(this.mWatchService,
									new WatchEvent.Kind[] { StandardWatchEventKinds.ENTRY_CREATE,
											StandardWatchEventKinds.ENTRY_MODIFY,
											StandardWatchEventKinds.ENTRY_DELETE });
					this.mListeners.put(fileName, listener);
					this.mWatchKeys.put(key, path);
					File[] fileList = file.listFiles();
					for (File f : fileList)
						listener.FileChanged(f.getPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (file.isFile()) {
				Path path = Paths.get(file.getParent(), new String[0]);
				try {
					WatchKey key = path
							.register(this.mWatchService,
									new WatchEvent.Kind[] { StandardWatchEventKinds.ENTRY_CREATE,
											StandardWatchEventKinds.ENTRY_MODIFY,
											StandardWatchEventKinds.ENTRY_DELETE });

					this.mListeners.put(file.toString(), listener);
					this.mWatchKeys.put(key, path);
					listener.FileChanged(file.getName().substring(0, file.getName().lastIndexOf(".")));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted())
			try {
				WatchKey key = this.mWatchService.take();
				Path path = (Path) this.mWatchKeys.get(key);
				for (WatchEvent event : key.pollEvents()) {
					WatchEvent ev = event;

					Path changedPath = path.resolve((Path) ev.context());
					if (this.mListeners.containsKey(changedPath.toString())) {
						String file = changedPath.getFileName().toString();
						((FileWatcherListener) this.mListeners.get(changedPath.toString()))
								.FileChanged(file.substring(0, file.lastIndexOf(".")));
					}
				}
				key.reset();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

}