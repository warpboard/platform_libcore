/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.nio.channels;

import java.io.Closeable;
import java.io.IOException;
import java.net.SocketAddress;

/**
 * A common interface for channels that are backed by network sockets.
 *
 * @since 1.7
 */
public interface NetworkChannel extends AutoCloseable, Channel, Closeable {

    /**
     * Binds this channel to the given local socket address. If the {@code localAddr} is set
     * to {@code null} the socket will be bound to an available local address on any free port of
     * the system.
     *
     * @param local the local machine address and port to bind on.
     * @return this channel.
     * @throws UnsupportedAddressTypeException if the {@code SocketAddress} is not supported.
     * @throws ClosedChannelException if the channel is closed.
     * @throws AlreadyBoundException if the channel is already bound.
     * @throws IOException if another I/O error occurs.
     */
    NetworkChannel bind(SocketAddress local) throws IOException;

    /**
     * Returns the local socket address the channel is bound to. The socket may be bound explicitly
     * via {@link #bind(java.net.SocketAddress)} or similar methods, or as a side-effect when other
     * methods are called, depending on the implementation. If the channel is not bound {@code null}
     * is returned.
     *
     * <p>If IP is being used, the returned object will be a subclass of
     * {@link java.net.InetSocketAddress}
     *
     * @return the local socket address, or {@code null} if the socket is not bound
     * @throws ClosedChannelException if the channel is closed.
     * @throws IOException if another I/O error occurs.
     */
    SocketAddress getLocalAddress() throws IOException;
}
