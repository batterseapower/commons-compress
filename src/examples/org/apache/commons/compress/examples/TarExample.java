/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.compress.examples;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.compress.Archive;
import org.apache.commons.compress.ArchiveException;
import org.apache.commons.compress.ArchiverFactory;

public class TarExample {

	/**
	 * Example for Tar-packing
	 */
	public void pack() {
		try {
			Archive archiver = ArchiverFactory.getInstance("tar");
			archiver.add(new File("C:\\Temp\\allclasses-frame.html"));
			archiver.add(new File("C:\\Temp\\allclasses-frame.html.bz2"));
			archiver.save(new File("C:\\Temp\\myTar.tar"));
		} catch (ArchiveException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Example for an unpack operation
	 */
	public void unpack() {
		try {
			Archive archiver = ArchiverFactory.getInstance( 
				new File("C:\\Temp\\myTar.tar"));
			archiver.unpack(new File("C:\\Temp\\unpacked\\"));
		} catch (ArchiveException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TarExample().pack();
		new TarExample().unpack();
	}
}
