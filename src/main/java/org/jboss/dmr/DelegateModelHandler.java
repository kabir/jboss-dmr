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

import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 * @version $Revision: 1.1 $
 */
public abstract class DelegateModelHandler {

    void protect() {

    }

    protected final  ModelNode getModelNode() {
        ModelNode node = getModelNode();
        if (node != null) {
            node.protect();
        }
        return node;
    }

    protected abstract ModelNode readModelNode();

    protected abstract DelegateModelHandler clone();

    protected abstract Set<String> getKeys();

    protected abstract ModelNode getChild(String name);

    protected abstract ModelNode getChild(int index);

    protected abstract boolean has(int index);

    protected abstract boolean has(String key);

    protected abstract ModelNode requireChild(String name) throws NoSuchElementException;

    protected abstract ModelNode requireChild(int index) throws NoSuchElementException;
}
