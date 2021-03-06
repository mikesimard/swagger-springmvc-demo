package com.ak.swaggermvc.demo

import com.ak.swaggermvc.demo.modules.OperationModule
import com.ak.swaggermvc.demo.modules.ResourceListingModule
import com.ak.swaggermvc.demo.pages.SwaggerApiPage
import geb.spock.GebSpec

class SwaggerBusinessApiModelSpec extends GebSpec {

    def setupSpec() {
        SwaggerApiPage.url = "${browser.config.rawConfig.baseUrl}/swaggerBusiness"
        to(SwaggerApiPage)
    }

    def "get list of businesses model"() {
      when:
        SwaggerApiPage swaggerApiPage = page
        ResourceListingModule resourceListingModule = swaggerApiPage.resourceListing('Businesses')
        resourceListingModule.expand()

      then:
        resourceListingModule.operations.size() == 6
        OperationModule operation = resourceListingModule.operationById('Businesses_list_get_0')
        operation.httpMethod == 'GET'

    }

}
