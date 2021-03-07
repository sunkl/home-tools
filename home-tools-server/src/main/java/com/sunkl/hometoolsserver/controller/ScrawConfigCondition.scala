package com.sunkl.hometoolsserver.controller

import com.sunkl.hometoolsserver.service.ScrawConfigService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{CrossOrigin, GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/api/setting/scraw_config"))
class ScrawConfigCondition @Autowired()(
                                         val scrawConfigService: ScrawConfigService
                                       ) {
  @CrossOrigin
  @GetMapping(Array("/selectByLikeScrawName"))
  def selectByLikeScrawName(@RequestParam("scraw_name") scrawName: String): String = {
    val list = scrawConfigService.selectLikeName(scrawName).map(element => s"""{"label":"${element.getScrawId}","value":"${element.getScrawName}"}""")
    s"[${list.mkString(",")}]"
  }
}
