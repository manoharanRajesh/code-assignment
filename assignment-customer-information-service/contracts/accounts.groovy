package contracts

import org.springframework.cloud.contract.spec.Contract
import java.util.regex.Pattern
Contract.make {
    name("get-accounts")
    request {
        method 'GET'
        urlPath('/accounts') {
            queryParameters {
                parameter 'ibans': equalTo('NL91BANK0123456789,NL91BANK0123456781')
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
                [
                  {
                    "IBAN": "NL91BANK0123456789",
                    "type": "savings",
                    "customerName": "Neo",
                    "currency": "EUR",
                    "balance": "5000"
                  },
                  {
                    "IBAN": "NL91BANK0123456781",
                    "type": "current",
                    "customerName": "Neo",
                    "currency": "EUR",
                    "balance": "3421.12"
                  }
                ]
         """)

    }
    priority 10
}