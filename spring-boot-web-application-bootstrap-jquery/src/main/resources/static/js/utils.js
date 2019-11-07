/* TODO: Currently, this is (essentially) a duplicate of the RIUTIL.sendXMLReq logic.  It is included here
*   so that the AJAX framework will be available without having to import a 5000+ line JS library (RIView)
*   just for that purpose.  Ultimately, we should replace the RIUTIL/RIView version with a wrapper around 
 *   this one so there is not dual-maintenance, but that is too risky to do during 9.1.3 regression.
*/
var E1AJAX = {
    sendXMLReq : function (method, containerId, action, handler, doc) {
        // code for IE 7, FireFox, Safari, etc.
        if (window.XMLHttpRequest) {
            var xmlReqObject = new XMLHttpRequest();
        }
        else if (window.ActiveXObject) {
            var xmlReqObject = new ActiveXObject("MSXML2.XMLHTTP");
        }

        if (xmlReqObject != null) {
            xmlReqObject.open(method, action, true);
            var handlerFunction = E1AJAX.getReadyStateHandler(xmlReqObject, handler, containerId);
            xmlReqObject.onreadystatechange = handlerFunction;
            //do not send content type with GET requests
            if(!(method.toUpperCase()=== 'GET'))
            {
                xmlReqObject.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            }
            try {
                xmlReqObject.send(doc);
            }
            catch (e) {
            }
            // SSO logout from web center may cause interaction of E1 failure
        }

    },
    getReadyStateHandler : function (req, responseHandler, containerId) {
        // Return an anonymous function that listens to the 
        // XMLHttpRequest instance
        return function () {
            // If the request's status is "complete"
            if (req.readyState == 4) {
                // Check that a successful server response was received
                switch (req.status) {
                    case 200:
                    // Pass the XML payload of the response to the 
                    // handler function
                        if (responseHandler)
                            responseHandler(containerId, req.responseText);
                        break;

                    case 122:
                    // SSO logout already from web center but E1 is still opened
                        E1AJAX.timeout();
                        break;

                    case 404:
                    // possible XSS attack 
                        if (window.RIUTIL && RIUTIL.CONSTANTS && RIUTIL.CONSTANTS.RI_EXIT_FOR_XSS) {
                            E1AJAX.timeout(RIUTIL.CONSTANTS.RI_EXIT_FOR_XSS);
                        }
                        else {
                            E1AJAX.timeout();
                        }
                        break;

                    // Safari intermittently encounters status 0 states.
                    // Bypass the alert error in the default below with a case for this
                    // state with no specific logic for it.
                    case 0:
                        break;

                    default :
                    // An HTTP problem has occurred
                        alert("HTTP error: " + req.status);
                }
            }
        }
    },
    timeout : function (message) {
        if (message)
            alert(message);
        top.location.replace(top.location.href);
    },
    sendSyncXMLReq : function (method, action) {
        // code for IE 7, FireFox, Safari, etc.
        if (window.XMLHttpRequest) {
            var xmlReqObject = new XMLHttpRequest();
        }
        else if (window.ActiveXObject) {
            var xmlReqObject = new ActiveXObject("MSXML2.XMLHTTP");
        }

        if (xmlReqObject != null) {
            xmlReqObject.open(method, action, false);
            xmlReqObject.send(null);
            if (xmlReqObject.status === 200) {
                try {
                    return xmlReqObject.responseText;
                }
                catch (e) {
                }
            }
        }
    }
};