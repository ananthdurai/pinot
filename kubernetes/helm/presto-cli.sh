#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#

if [[ $(nc -z  localhost 8080) != 0 ]]; then
  kubectl port-forward service/presto-coordinator 8080:8080 -n pinot-quickstart > /dev/null &
fi
sleep 2
open http://localhost:8080/

# Just for blocking
tail -f /dev/null
pkill -f "kubectl port-forward sservice/presto-coordinator 8080:8080 -n pinot-quickstart"
