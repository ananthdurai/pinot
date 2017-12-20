/**
 * Copyright (C) 2014-2016 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.pinot.common.utils;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.params.DefaultHttpParams;
import org.apache.commons.httpclient.params.HttpParams;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHeaders;


public class UserAgentHeader {

  private static final String USER_AGENT_PARAM = "http.useragent";
  private static final String SPACE = " ";
  // TODO: Get jar version
  private static final String VERSION = "1.0";

  public static String getTaskType(String userAgentHeader) {
    return StringUtils.substringsBetween(
        userAgentHeader, CommonConstants.Minion.MINION_HEADER_PREFIX, CommonConstants.Minion.MINION_HEADER_SEPARATOR)[0];
  }

  public static Header constructUserAgentHeader(String jobType) {
    HttpParams httpParams = DefaultHttpParams.getDefaultParams();
    String userAgentParameter = String.valueOf(httpParams.getParameter(USER_AGENT_PARAM));
    userAgentParameter += SPACE + CommonConstants.Minion.MINION_HEADER_PREFIX + jobType + CommonConstants.Minion.MINION_HEADER_SEPARATOR + VERSION;

    return new Header(HttpHeaders.USER_AGENT, userAgentParameter);
  }


}
