﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>LP简历管理-教育信息</title>
    <%@include file="common/head.jsp" %>
</head>

<body class="theme-blue">

<%@include file="common/top.jsp" %>

<section class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>教育信息</h2>
                    </div>


                    <div class="body table-responsive">

                        <div class="menus">
                            <div class="buttons">
                                <button type="button" class="btn bg-blue waves-effect btn-sm"
                                        onclick="add()"
                                <%--                                            data-toggle="modal" data-target="#add-form-box"--%>
                                >
                                    <i class="material-icons">add</i>
                                    <span>添加</span>
                                </button>
                                <%--  删除多个  --%>
                                <button type="button"
                                        class="btn bg-pink waves-effect btn-sm removeAll disabled"
                                        disabled
                                        onclick="removeAll()">
                                    <i class="material-icons">delete</i>
                                    <span>删除选中</span>
                                </button>
                            </div>
                        </div>

                        <c:if test="${not empty educations}">
                            <form id="remove_all_form" action="${ctx}/education/remove" method="post">

                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                    <tr>
                                        <th>
                                            <div class="switch">
                                                <label><input type="checkbox"><span
                                                        class="lever switch-col-blue"></span></label>
                                            </div>
                                        </th>
                                        <th>名称</th>
                                        <th>开始</th>
                                        <th>结束</th>
                                        <th>类型</th>
                                        <th>简介</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach var="education" items="${educations}">
                                        <tr>
                                            <td>
                                                <div class="switch">
                                                    <label><input name="id" value="${education.id}"
                                                                  type="checkbox"><span
                                                            class="lever switch-col-blue"></span></label>
                                                </div>
                                            </td>
                                            <td>${education.name}</td>
                                            <td><f:formatDate pattern="yyyy-MM-dd" value="${education.beginDay}"/></td>
                                            <td><f:formatDate pattern="yyyy-MM-dd" value="${education.endDay}"/></td>
                                            <td>${education.typeString}</td>
                                            <td>${education.intro}</td>
                                            <td>
                                                <button type="button" class="btn bg-blue waves-effect btn-xs"
                                                        onclick="edit(${education.json})">
                                                    <i class="material-icons">edit</i>
                                                    <span>编辑</span>
                                                </button>
                                                <button type="button" class="btn bg-pink waves-effect btn-xs"
                                                        onclick="remove('${education.name}', '${education.id}')">
                                                    <i class="material-icons">delete</i>
                                                    <span>删除</span>
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>

                            </form>
                        </c:if>


                    </div>


                </div>
            </div>
        </div>
    </div>
</section>

<!--  add-form-box  -->
<div class="modal fade" id="add-form-box" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">添加教育</h4>
            </div>
            <div class="modal-body">
                <form action="${ctx}/education/save" class="form-validation" method="post">
                    <input type="text" style="display: none" name="id">
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                            <label for="name">名称</label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                            <div class="form-group">
                                <div class="form-line">
                                    <input type="text" id="name" name="name" maxlength="20" class="form-control"
                                           placeholder="名称"
                                           required>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                            <label>类型</label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                            <div class="form-group">
                                <select name="type">
                                    <option value="1">小学</option>
                                    <option value="2">初中</option>
                                    <option value="3">高中</option>
                                    <option value="4">中专</option>
                                    <option value="5">大专</option>
                                    <option value="6" selected>本科</option>
                                    <option value="7">硕士</option>
                                    <option value="8">博士</option>
                                    <option value="0">其它</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                            <label for="beginDay">入学</label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                            <div class="form-group">
                                <div class="form-line">
                                    <input type="date" id="beginDay" name="beginDay" class="form-control"
                                           required>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                            <label for="endDay">毕业</label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                            <div class="form-group">
                                <div class="form-line">
                                    <input type="date" id="endDay" name="endDay" class="form-control"
                                           required>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                            <label for="intro">简介</label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                            <div class="form-group">
                                <div class="form-line">
                                    <textarea name="intro" maxlength="1000" id="intro" cols="30" rows="5"
                                              class="form-control no-resize" placeholder="简介"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--  添加  --%>
                    <div class="row">
                        <div class="col-lg-offset-2 col-md-offset-2 col-sm-offset-3 col-xs-offset-3">
                            <button class="btn btn-primary waves-effect m-l-15" type="submit">保存</button>
                            <button class="btn btn-info waves-effect m-l-15" data-dismiss="modal">关闭</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>

<script>

    $('.education').addClass('active')

    addValidatorRules('.form-validation')
    const $box = $('#add-form-box')
    const $form = $box.find('form')
    const $removeAllForm = $('#remove_all_form')
    // const $boxFormId = $form.find('[name=id]')
    // const $boxFormName = $form.find('[name=name]')
    // const $boxFormBeginDay = $form.find('[name=beginDay]')
    // const $boxFormEndDay = $form.find('[name=endDay]')
    // const $boxFormType = $form.find('[name=type]')
    // const $boxFormIntro = $form.find('[name=intro]')

    function add() {
        // document.getElementById() document.querySelector()获得的是原生的DOM对象
        // $()获取的是jQuery包装过的对象，并不是原生的DOM对象
        // $()[]这样才能获取原生的DOM对象
        // 原生的form对象有一个reset方法
        // form.reset()

        // 根据需要看是否需要重置表单
        $form[0].reset()
        $box.modal()

        // 另外一种写法
        // $('#add-form-box').clone(true).modal()
        // 性能有点差
    }

    function edit(education) {
        add()

        for (const k in education) {
            $form.find('[name=' + k + ']').val(education[k])
        }

        // 填充表单信息
        // $boxFormId.val(education.id) // $('#add-form-box [name=name]').val('')
        // $boxFormName.val(education.name) // $('#add-form-box [name=name]').val('')
        // $boxFormBeginDay.val(education.beginDay) // $('#add-form-box [name=beginDay]').val('')
        // $boxFormEndDay.val(education.endDay) // $('#add-form-box [name=endDay]').val('')
        // $boxFormType.val(education.type) // $('#add-form-box [name=type]').val('')
        // $boxFormIntro.val(education.intro) // $('#add-form-box [name=intro]').val('')
    }

    function remove(name, id) {
        swal({
            title: "你确定？",
            text: '你确定要删除【' + name + '】？',
            icon: 'warning',
            dangerMode: true,
            buttons: {
                cancel: '取消',
                confirm: '确定'
            }
        }).then(willDelete => {
            if (!willDelete) return

            <%--window.location.href = '${ctx}/education/remove?id=' + id--%>
            location.href = '${ctx}/education/remove?id=' + id

            // swal({
            //     title: '删除成功',
            //     text: '【' + name + '】已经被删除！',
            //     icon: 'success',
            //     timer: 1500,
            //     buttons: false
            // })
        })
    }

    function removeAll() {
        swal({
            title: "你确定？",
            text: "你确定要删除所有选中的记录？",
            icon: "warning",
            dangerMode: true,
            buttons: {
                cancel: "取消",
                confirm: "确定"
            }
        }).then(willDelete => {
            if (!willDelete) return

            $removeAllForm.submit()

            // swal({
            //     title: "删除成功",
            //     text: "被选中的记录已经被删除！",
            //     icon: "success",
            //     timer: 1500,
            //     buttons: false
            // })
        })
    }

    const $set = $(".table tbody tr input[type=checkbox]")
    const $removeAll = $('.table-responsive .removeAll')
    $('.table thead th input[type=checkbox]').change(function () {
        let checked = $(this).is(":checked")
        if (checked) {
            $set.each(function () {
                $(this).prop("checked", true)
                $(this).parents('tr').addClass("active")
            })
            $removeAll.removeClass('disabled')
            $removeAll.prop('disabled', false)
        } else {
            $set.each(function () {
                $(this).prop("checked", false)
                $(this).parents('tr').removeClass("active")
            })
            $removeAll.addClass('disabled')
            $removeAll.prop('disabled', true)
        }
    })

    $set.change(function () {
        $(this).parents('tr').toggleClass("active")
        if ($('.table tbody tr input[type=checkbox]:checked').length > 0) {
            $removeAll.removeClass('disabled')
            $removeAll.prop('disabled', false)
        } else {
            $removeAll.addClass('disabled')
            $removeAll.prop('disabled', true)
        }
    })
</script>

</body>

</html>
