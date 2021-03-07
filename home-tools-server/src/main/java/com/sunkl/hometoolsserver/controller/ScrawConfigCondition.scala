package com.sunkl.hometoolsserver.controller

import com.sunkl.hometoolsserver.service.ScrawConfigService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Condition
@Condition
class ScrawConfigCondition @Autowired()(
                                         val scrawConfigService: ScrawConfigService
                                       ) {

}
