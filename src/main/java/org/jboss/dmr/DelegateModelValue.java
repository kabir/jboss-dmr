/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
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
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
final class DelegateModelValue extends ModelValue {

    private final DelegateModelHandler delegate;

    DelegateModelValue(final DelegateModelHandler delegate) {
        super(ModelType.OBJECT);
        this.delegate = delegate;
    }

    @Override
    ModelNode asObject() {
        return delegate.getModelNode();
    }

    @Override
    ModelNode getChild(String name) {
        return delegate.getChild(name);
    }

    @Override
    ModelNode getChild(int index) {
        return delegate.getChild(index);
    }

    @Override
    boolean has(int index) {
        return delegate.has(index);
    }

    @Override
    boolean has(String key) {
        return delegate.has(key);
    }

    @Override
    ModelNode requireChild(String name) throws NoSuchElementException {
        return delegate.requireChild(name);
    }

    @Override
    ModelNode requireChild(int index) throws NoSuchElementException {
        return delegate.requireChild(index);
    }

    @Override
    Set<String> getKeys() {
        return delegate.getKeys();
    }

    @Override
    String asString() {
        return delegate.getModelNode().asString();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof DelegateModelValue && other.equals(this);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }


}
