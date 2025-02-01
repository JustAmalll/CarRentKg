function gtag_report_conversion(url) {
    var callback = function () {
        if (typeof(url) !== 'undefined') {
            window.location = url;
        }
    };
    gtag('event', 'conversion', {
        'send_to': 'AW-16845554442/NZaMCJ_xxpcaEIqGy-A-',
        'event_callback': callback
    });
    return false;
}