/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.resourceresolver.impl.mapping;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Apache Sling String Interpolation Provider",
    description = "Configures the String Interpolation Provider and the location of its key/value pairs")
public @interface StringInterpolationProviderConfiguration {

    String DEFAULT_PREFIX = "${";
    String DEFAULT_SUFFIX = "}";
    char DEFAULT_ESCAPE_CHARACTER = '$';
    boolean DEFAULT_IN_VARIABLE_SUBSTITUTION = false;

    // Setup for the String Substitution
    @AttributeDefinition(
        name = "Substitution Prefix",
        description = "The Prefix of the Variable to be replaced (default = '${')")
    String substitutionPrefix() default DEFAULT_PREFIX;
    @AttributeDefinition(
        name = "Substitution Suffix",
        description = "The Suffix of the Variable to be replaced (deault = '}'")
    String substitutionSuffix() default DEFAULT_SUFFIX;
    @AttributeDefinition(
        name = "Substitution Escape Character",
        description = "The Escape Character for Prefix or Suffix (default = '$'")
    char substitutionEscapeCharacter() default DEFAULT_ESCAPE_CHARACTER;
    @AttributeDefinition(
        name = "Enable Substitution in Variables",
        description = "Flag that indicates if substitution is allowed in Variables (default = false")
    boolean substitutionInVariables() default DEFAULT_IN_VARIABLE_SUBSTITUTION;

    @AttributeDefinition(
        name = "Placeholder Values",
        description = "A list of key / value pairs separated by a equal (=) sign. " +
            "The key is not permitted to contain a '=' sign and the first occurrence of '=' " +
            "separates the key from the value. If no '=' is found the entire key / value pair " +
            "is dropped.")
    String[] placeHolderKeyValuePairs() default {"phv.default.host.name=localhost"};

//AS TODO: Future Development
//    @AttributeDefinition(
//        name = "Placeholder Source URL",
//        description = "A URL pointing to a source text file with key/value pairs (one value per line)")
//    String[] placeHolderKeyValueSourceUrl();
}
