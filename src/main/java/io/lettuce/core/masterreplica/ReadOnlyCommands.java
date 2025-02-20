/*
 * Copyright 2020-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lettuce.core.masterreplica;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import io.lettuce.core.protocol.CommandType;
import io.lettuce.core.protocol.ProtocolKeyword;

/**
 * Contains all command names that are read-only commands.
 *
 * @author Mark Paluch
 */
class ReadOnlyCommands {

    private static final Set<CommandType> READ_ONLY_COMMANDS = EnumSet.noneOf(CommandType.class);

    static {
        for (CommandName commandNames : CommandName.values()) {
            READ_ONLY_COMMANDS.add(CommandType.valueOf(commandNames.name()));
        }
    }

    /**
     * @param protocolKeyword must not be {@code null}.
     * @return {@code true} if {@link ProtocolKeyword} is a read-only command.
     */
    public static boolean isReadOnlyCommand(ProtocolKeyword protocolKeyword) {
        return READ_ONLY_COMMANDS.contains(protocolKeyword);
    }

    /**
     * @return an unmodifiable {@link Set} of {@link CommandType read-only} commands.
     */
    public static Set<CommandType> getReadOnlyCommands() {
        return Collections.unmodifiableSet(READ_ONLY_COMMANDS);
    }

    enum CommandName {
        ASKING, BITCOUNT, BITPOS, CLIENT, COMMAND, DUMP, ECHO, EVAL_RO, EVALSHA_RO, EXISTS, //
        GEODIST, GEOPOS, GEORADIUS, GEORADIUS_RO, GEORADIUSBYMEMBER, GEORADIUSBYMEMBER_RO, GEOHASH, GET, GETBIT, //
        GETRANGE, HEXISTS, HGET, HGETALL, HKEYS, HLEN, HMGET, HRANDFIELD, HSCAN, HSTRLEN, //
        HVALS, INFO, KEYS, LINDEX, LLEN, LPOS, LRANGE, SORT_RO, MGET, PFCOUNT, PTTL, //
        RANDOMKEY, READWRITE, SCAN, SCARD, SCRIPT, //
        SDIFF, SINTER, SISMEMBER, SMEMBERS, SRANDMEMBER, SSCAN, STRLEN, //
        SUNION, TIME, TTL, TYPE, //
        XINFO, XLEN, XPENDING, XRANGE, XREVRANGE, XREAD, //
        ZCARD, ZCOUNT, ZLEXCOUNT, ZRANGE, //
        ZRANDMEMBER, ZRANGEBYLEX, ZRANGEBYSCORE, ZRANK, ZREVRANGE, ZREVRANGEBYLEX, ZREVRANGEBYSCORE, ZREVRANK, ZSCAN, ZSCORE,
    }

}
