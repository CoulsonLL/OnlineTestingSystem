function searchToggle(obj, evt)
{
    var container = $(obj).closest('.search-wrapper');
    var input = $(".search-input");

    if (!container.hasClass('active'))
    {
        container.addClass('active');
        input.focus();

        evt.preventDefault();
    }
    else if (container.hasClass('active') && $(obj).closest('.input-holder').length == 0)
    {
        container.removeClass('active');
        // clear input
        container.find('.search-input').val('');
        // clear and hide result container when we press close
        container.find('.result-container').fadeOut(100, function () {
            $(this).empty();
        });
    }
}

function submitFn(obj, evt)
{
    value = $(obj).find('.search-input').val().trim();

    // _html = "Yup yup! Your search text sounds like this: ";
    if (!value.length)
    {
        _html = "Yup yup! Add some text friend :D";
    }
    else
    {
        _html += "<b>" + value + "</b>";

        $.ajax({
            url: "/OnlineTestingSystem_war_exploded/SearchServlet",
            timeout:1000,
            data: {
                "user-input": $(".search-input").val(),
            },
            type: "POST",
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            success: function (result) {
                if (result == "true")
                {
                    window.location.href = "SearchResult.xhtml";
                }
            },
            error: function (result) {
                alert("Search Failed");
            }
        });
        // var xmlHttp = XMLHttpRequest();
        // xmlHttp.open("POST", "SearchServlet", true);
        // xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        // xmlHttp.send("user-input=" + input.val());
    }

    $(obj).find('.result-container').html('<span>' + _html + '</span>');
    $(obj).find('.result-container').fadeIn(800);
    $(obj).find('.result-container').fadeOut(800);

    evt.preventDefault();
}