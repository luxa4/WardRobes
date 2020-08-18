;$(function() {

    var init = function() {
        $('#addToCart').click(addProductToCart);
        $('.removeFromProductToCart').click(removeFromProductToCart);
        $('#showResult').click(showResult);

        var minLen  = $('#polzunok-length-min').attr('data-min');
        var maxLen  = $('#polzunok-length-max').attr('data-max');
        var minWid  = $('#polzunok-width-min').attr('data-min');
        var maxWid  = $('#polzunok-width-max').attr('data-max');
        var minHei  = $('#polzunok-height-min').attr('data-min');
        var maxHei  = $('#polzunok-height-max').attr('data-max');
        var minPrice = $('#polzunok-price-min').attr('data-min');
        var maxPrice = $('#polzunok-price-max').attr('data-max');

        //Slider -5
        $(".polzunok-5").slider({
            min: 0,
            max: maxLen,
            values: [minLen, maxLen], // Default значения ползунков
            range: true,  // если было бы FALSE - был бы один полузунок
            animate: "fast",
            slide : function(event, ui) {
                $(".polzunok-input-5-left").val(ui.values[0]);
                $(".polzunok-input-5-right").val(ui.values[1]);
                $(".polzunok-input-5-left").attr("data-value", ui.values[0]);
                $(".polzunok-input-5-right").attr("data-value", ui.values[1]);
            },
            stop: function(event, ui){
                var minLen  = $('#polzunok-length-min').attr('data-value');
                var maxLen  = $('#polzunok-length-max').attr('data-value');
                var minWidth  = $('#polzunok-width-min').attr('data-value');
                var maxWidth  = $('#polzunok-width-max').attr('data-value');
                var minHeight  = $('#polzunok-height-min').attr('data-value');
                var maxHeight  = $('#polzunok-height-max').attr('data-value');
                var minPrice = $('#polzunok-price-min').attr('data-value');
                var maxPrice = $('#polzunok-price-max').attr('data-value');

                $.ajax({
                    url:'/searchButtonCount',
                    type:'GET',
                    data: {
                        minLen: minLen,
                        maxLen: maxLen,
                        minWidth: minWidth,
                        maxWidth: maxWidth,
                        minHeight: minHeight,
                        maxHeight: maxHeight,
                        minPrice: minPrice,
                        maxPrice: maxPrice,
                    },
                    success: function(jsonCart) {
                        $('#filterResult').html(' (' + jsonCart.totalCount + ' шт)');
                    },
                });
            }
        });

        $(".polzunok-input-5-left").val($(".polzunok-5").slider("values", 0));
        $(".polzunok-input-5-right").val($(".polzunok-5").slider("values", 1));
        $(".polzunok-input-5-left").attr("data-value", $(".polzunok-5").slider("values", 0));
        $(".polzunok-input-5-right").attr("data-value", $(".polzunok-5").slider("values", 1));


        // Slider-4
        $(".polzunok-4").slider({
                min: 0,
                max: maxWid,
                values: [minWid, maxWid],
                range: true,
                animate: "fast",
                slide : function(event, ui) {    
                    $(".polzunok-input-4-left").val(ui.values[ 0 ]);
                    $(".polzunok-input-4-right").val(ui.values[ 1 ]);
                    $(".polzunok-input-4-left").attr("data-value", ui.values[0]);
                    $(".polzunok-input-4-right").attr("data-value", ui.values[1]);

                },
                stop: function (event, ui){
                    var minLen  = $('#polzunok-length-min').attr('data-value');
                    var maxLen  = $('#polzunok-length-max').attr('data-value');
                    var minWidth  = $('#polzunok-width-min').attr('data-value');
                    var maxWidth  = $('#polzunok-width-max').attr('data-value');
                    var minHeight  = $('#polzunok-height-min').attr('data-value');
                    var maxHeight  = $('#polzunok-height-max').attr('data-value');
                    var minPrice = $('#polzunok-price-min').attr('data-value');
                    var maxPrice = $('#polzunok-price-max').attr('data-value');

                    $.ajax({
                        url:'/searchButtonCount',
                        type:'GET',
                        data: {
                            minLen: minLen,
                            maxLen: maxLen,
                            minWidth: minWidth,
                            maxWidth: maxWidth,
                            minHeight: minHeight,
                            maxHeight: maxHeight,
                            minPrice: minPrice,
                            maxPrice: maxPrice,
                        },
                        success: function(jsonCart) {
                            $('#filterResult').html(' (' + jsonCart.totalCount + ' шт)');
                        },
                    });
                }
        });

        $(".polzunok-input-4-left").val($(".polzunok-4").slider("values", 0));
        $(".polzunok-input-4-right").val($(".polzunok-4").slider("values", 1));
        $(".polzunok-input-4-left").attr("data-value", $(".polzunok-4").slider("values", 0));
        $(".polzunok-input-4-right").attr("data-value", $(".polzunok-4").slider("values", 1));


        //Slider-3
        $(".polzunok-3").slider({
                min: 0,
                max: maxHei,
                values: [minHei, maxHei],
                range: true,
                animate: "fast",
                slide : function(event, ui) {    
                    $(".polzunok-input-3-left").val(ui.values[ 0 ]);
                    $(".polzunok-input-3-right").val(ui.values[ 1 ]);
                    $(".polzunok-input-3-left").attr("data-value", ui.values[0]);
                    $(".polzunok-input-3-right").attr("data-value", ui.values[1]);

                },
                stop: function (event, ui){
                    var minLen  = $('#polzunok-length-min').attr('data-value');
                    var maxLen  = $('#polzunok-length-max').attr('data-value');
                    var minWidth  = $('#polzunok-width-min').attr('data-value');
                    var maxWidth  = $('#polzunok-width-max').attr('data-value');
                    var minHeight  = $('#polzunok-height-min').attr('data-value');
                    var maxHeight  = $('#polzunok-height-max').attr('data-value');
                    var minPrice = $('#polzunok-price-min').attr('data-value');
                    var maxPrice = $('#polzunok-price-max').attr('data-value');

                    $.ajax({
                        url:'/searchButtonCount',
                        type:'GET',
                        data: {
                            minLen: minLen,
                            maxLen: maxLen,
                            minWidth: minWidth,
                            maxWidth: maxWidth,
                            minHeight: minHeight,
                            maxHeight: maxHeight,
                            minPrice: minPrice,
                            maxPrice: maxPrice,
                        },
                        success: function(jsonCart) {
                            $('#filterResult').html(' (' + jsonCart.totalCount + ' шт)');
                        },
                    });
                }
        });

        $(".polzunok-input-3-left").val($(".polzunok-3").slider("values", 0));
        $(".polzunok-input-3-right").val($(".polzunok-3").slider("values", 1));
        $(".polzunok-input-3-left").attr("data-value", $(".polzunok-3").slider("values", 0));
        $(".polzunok-input-3-right").attr("data-value", $(".polzunok-3").slider("values", 1));



        //Slider-2
        $(".polzunok-2").slider({
                min: 0,
                max: maxPrice,
                values: [minPrice, maxPrice],
                range: true,
                animate: "fast",
                slide : function(event, ui) {    
                    $(".polzunok-input-2-left").val(ui.values[ 0 ]);
                    $(".polzunok-input-2-right").val(ui.values[ 1 ]);
                    $(".polzunok-input-2-left").attr("data-value", ui.values[0]);
                    $(".polzunok-input-2-right").attr("data-value", ui.values[1]);
                },
                stop: function (event, ui){
                    var minLen  = $('#polzunok-length-min').attr('data-value');
                    var maxLen  = $('#polzunok-length-max').attr('data-value');
                    var minWidth  = $('#polzunok-width-min').attr('data-value');
                    var maxWidth  = $('#polzunok-width-max').attr('data-value');
                    var minHeight  = $('#polzunok-height-min').attr('data-value');
                    var maxHeight  = $('#polzunok-height-max').attr('data-value');
                    var minPrice = $('#polzunok-price-min').attr('data-value');
                    var maxPrice = $('#polzunok-price-max').attr('data-value');


                    $.ajax({
                        url:'/searchButtonCount',
                        type:'GET',
                        data: {
                            minLen: minLen,
                            maxLen: maxLen,
                            minWidth: minWidth,
                            maxWidth: maxWidth,
                            minHeight: minHeight,
                            maxHeight: maxHeight,
                            minPrice: minPrice,
                            maxPrice: maxPrice,
                        },
                        success: function(jsonCart) {
                            $('#filterResult').html(' (' + jsonCart.totalCount + ' шт)');
                        },
                    });
                }

        });

        $(".polzunok-input-2-left").val($(".polzunok-2").slider("values", 0));
        $(".polzunok-input-2-right").val($(".polzunok-2").slider("values", 1));
        $(".polzunok-input-2-left").attr("data-value", $(".polzunok-2").slider("values", 0));
        $(".polzunok-input-2-right").attr("data-value", $(".polzunok-2").slider("values", 1));

    };

    var addProductToCart = function(){
        var productId = $('#productId').val();
        var count = $('#count').val();

        $.ajax({
            url:'/addToShoppingCart',
            type:'GET',

            data: {
                productId: productId,
                count: count
            },
            success: function(shoppingCart) {
                $('#shoppingCartPanel').removeClass('hidden');
                $('#shoppingCart .total-count').text(shoppingCart.totalCount);
            },
        });
    };

    var removeFromProductToCart = function(){
        var btn = $(this);
        var productId = btn.attr('data-id-product');
        var count = btn.attr('data-count');


        $.ajax({
            url:'/removeFromShoppingCart',
            type:'GET',
            data: {
                productId: productId,
                count: count
            },
            success: function(shoppingCart) {
                $('#shoppingCart .total-count').text(shoppingCart.totalCount);
                $('#'+productId).remove();
            },
        });
    };

    var showResult = function() {

        var minLen  = $('#polzunok-length-min').attr('data-value');
        var maxLen  = $('#polzunok-length-max').attr('data-value');
        var minWidth  = $('#polzunok-width-min').attr('data-value');
        var maxWidth  = $('#polzunok-width-max').attr('data-value');
        var minHeight  = $('#polzunok-height-min').attr('data-value');
        var maxHeight  = $('#polzunok-height-max').attr('data-value');
        var minPrice = $('#polzunok-price-min').attr('data-value');
        var maxPrice = $('#polzunok-price-max').attr('data-value');

        $.ajax({
            url:'/search',
            type:'GET',
            data: {
                minLen: minLen,
                maxLen: maxLen,
                minWidth: minWidth,
                maxWidth: maxWidth,
                minHeight: minHeight,
                maxHeight: maxHeight,
                minPrice: minPrice,
                maxPrice: maxPrice,
            },
            success: function(html) {
                $('#content').html(html);
                // $('#'+productId).remove();

            },
        });
    };
   
    init();
});