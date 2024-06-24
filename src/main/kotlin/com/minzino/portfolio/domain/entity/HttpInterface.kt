package com.minzino.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(
    httpServletRequest: HttpServletRequest
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    val id: Long? = null;

    
    var cookies: String? = httpServletRequest.cookies
        //cokies 안에있는 키벨류 값을 찾기위한 스트림
        ?.map {"${it.name}:${it.value}"  }
        ?.toString()
    //헤더에 있는 refere 값을 찾아와 저장
    var referer: String? =httpServletRequest.getHeader("refere")
    //요청 헤더에 있는 localAddr 정보 저장
    var localAddr: String? = httpServletRequest.localAddr
    //연결된 호스트(나자신)의 정보 저장
    var remoteHost: String? = httpServletRequest.remoteHost
    //요청된 URI 저장
    var requestUri: String? = httpServletRequest.requestURI
    //어떠한 경로로 요첮을 보내오는지 저장
    var userAgent: String?= httpServletRequest.getHeader("user-agent")

}