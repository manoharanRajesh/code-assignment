# Payment Initiation Sandbox API

At our bank, we are opening up payment initiation API for third party payment providers (TPPs). For testing purpose, we also provide a
sandbox environment to TPPs. The API definition is provided by the Open API format (see [api-definition.yaml](./api-definition.yaml). TPPs shall implement their application according to the definition,
so the application must be compiliant to it.


# Your task

You need to implement an web application which confirms the API definition. The application doesn't create actual payments but validating the incoming requests from TPPs and respond back the defined response.

These are the validations need to be in place.

* Certificate expiration validation
* White listed certificates validation
* Signature validation
* Request validation

When the above validation failed, then the application must return HTTP status code `400`. If the request passes the all validation, then the application must
return HTTP code `201`. The `paymentId` must be generated on the application.

# Response

The application must alway respond  with `Signature` and `Signature-Certificate` HTTP headers. The `Signature` header contains the signature of the response.

# Validation details

## Certificate expiration validation

An incoming certificate is format of X.509. You need to validate if the certificate is expired or not. If it's expired, the API must respond `EXPIRED_CERTIFICATE` error response code.

## White listed certificates validation

We only expose this API to selected TPPs at this moment. This is done by white listing incoming certificates. The way we are white listing is checking the common name (CN) of the subject name of incoming certificate.  If a CN start with `Sandbox-TPP`, then the certificate
is known. Otherwise, the application must respond `UNKNOWN_CERTIFICATE` error response code.

## Signature validation

The below pseudo code describes how to compute signature:

```
SHA256WithRSA(privateKey, headers['X-Request-Id'] + digest(SHA-256, requestBody))
```

The application must verify the signature with the incoming certificate, the `Signature-Certificate` header value, if the verification failed,
then it must respond `INVALID_SIGNATURE` error response code.

You can find an example signature in [example-signature.md](./example-signature.md) file.

## Request validation

The request body must be validated according to the format defined by  in the Open API file. For IBANs, The application doesn't need to check the check digits of the IBAN (it is nice to have, though).

If the IBAN validation is failed, then the application must respond`INVALID_REQUEST` error response code.


## GENERAL_ERROR

When something went wrong on the application, it must respond HTTP status code `500` and `GENERAL_ERROR` error response code. This includes an error case which
isn't applicable of the above validation error situation (e.g. missing certificate).

