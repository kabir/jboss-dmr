/*
* JBoss, Home of Professional Open Source.
* Copyright 2006, Red Hat Middleware LLC, and individual contributors
* as indicated by the @author tags. See the copyright.txt file in the
* distribution for a full listing of individual contributors. 
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/ 
package org.jboss.dmr;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 * @version $Revision: 1.1 $
 */
public class SerializeTest
{
   @Test
   public void testSerializeNodeWithBytes() throws Exception {
      ModelNode node = new ModelNode();
      node.get("name").set("theName");
      node.get("bytes").set(new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});

      ByteArrayOutputStream bout = new ByteArrayOutputStream();
      DataOutputStream dout = new DataOutputStream(bout);
      
      node.writeExternal(dout);
      dout.close();
      
      byte[] nodebytes = bout.toByteArray();
      
      System.out.println(Arrays.toString(nodebytes));
      
      ModelNode result = new ModelNode();
      result.readExternal(new DataInputStream(new ByteArrayInputStream(nodebytes)));

   }
}
