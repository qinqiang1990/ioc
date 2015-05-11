package maven.plugin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Goal which touches a timestamp file.
 *
 * @goal IOC
 * 
 * @phase process-sources
 */
public class CountMojo extends AbstractMojo
{
	/**
	 * Location of the file.
	 * @parameter expression="${project.includes}"
	 */
	private String[] includes;

	/**
	 * Location of the file.
	 * @parameter expression="${project.build.sourceDirectory}"
	 * src/main/java/
	 * @required
	 */
	private File sourceDirectory;

	public void execute()	throws MojoExecutionException{

		File f = sourceDirectory;

		if ( !f.exists() )
		{
			getLog().info("no	sourceDirectory	find");
		}

		List<File> list=new ArrayList<File>();
		list.add(f);
		while(list.size()>0)
		{
			File temp=list.remove(0);
			getLog().info(temp.getAbsolutePath());
			if(temp.isDirectory())
			{
				File[] temp_list=temp.listFiles();
				for(int i=0;i<temp_list.length;i++)
					list.add(temp_list[i]);
			}
		}
		for(int i=0;i<includes.length;i++)
		getLog().info("includes	"+i+":"+includes[i]);
		
	}

}
