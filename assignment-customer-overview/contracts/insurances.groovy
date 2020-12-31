package contracts

import org.springframework.cloud.contract.spec.Contract

import java.util.regex.Pattern

Contract.make {
    name("get-insurances")
    request {
        method 'GET'
        urlPath('/insurances') {
            queryParameters {
                parameter 'policy': equalTo('1234567890')
            }
        }
        headers {
            contentType('application/json')
        }
    }
    response {
        status 200
        headers {
            contentType('application/json')
        }
        body("""
                {
                  "policyNumber": "1234567890",
                  "insurances": [
                      {
                        "type": "car-insurance",
                        "customers": ["rob"],
                        "coverage": "20000",
                        "premium": "100"
                      },
                      {
                
                        "type": "liability-insurance",
                        "customerName": ["rob"],
                        "coverage": "400000",
                        "premium": "20"
                      }
                    ]
                }
        """)

    }
    priority 10
}
