﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>小码哥简历管理-专业技能</title>
    <%@ include file="common/head.jsp" %>
</head>

<body class="theme-blue">
    <%@ include file="common/nav.jsp" %>

    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>专业技能</h2>
                        </div>
                        <div class="body table-responsive">
                            <div class="menus">
                                <div class="buttons">
                                    <button type="button" class="btn bg-blue waves-effect btn-sm"
                                            onclick="add()">
                                        <i class="material-icons">add</i>
                                        <span>添加</span>
                                    </button>
                                    <button type="button"
                                            class="btn bg-pink waves-effect btn-sm removeAll disabled"
                                            disabled
                                            onclick="removeAll()">
                                        <i class="material-icons">delete</i>
                                        <span>删除选中</span>
                                    </button>
                                </div>
                            </div>

                            <c:if test="${not empty skills}">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                    <tr>
                                        <th>
                                            <div class="switch">
                                                <label><input type="checkbox"><span class="lever switch-col-blue"></span></label>
                                            </div>
                                        </th>
                                        <th>名称</th>
                                        <th>级别</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <form id="remove-form" action="${ctx}/skill/remove" method="post">
                                        <c:forEach items="${skills}" var="skill">
                                            <tr>
                                                <td>
                                                    <div class="switch">
                                                        <label>
                                                            <input type="checkbox" name="id" value="${skill.id}">
                                                            <span class="lever switch-col-blue"></span>
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>${skill.name}</td>
                                                <td>${skill.levelString}</td>
                                                <td>
                                                    <button type="button" class="btn bg-blue waves-effect btn-xs"
                                                            onclick="edit(${skill.json})">
                                                        <i class="material-icons">edit</i>
                                                        <span>编辑</span>
                                                    </button>
                                                    <button type="button" class="btn bg-pink waves-effect btn-xs"
                                                            onclick="remove('${skill.id}', '${skill.name}', this)">
                                                        <i class="material-icons">delete</i>
                                                        <span>删除</span>
                                                    </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </form>
                                    </tbody>
                                </table>
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
                    <h4 class="modal-title">添加专业技能</h4>
                </div>
                <div class="modal-body">
                    <form class="form-validation" method="post" action="${ctx}/skill/save">
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
                                <label>级别</label>
                            </div>
                            <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                <div class="form-group">
                                    <select name="level">
                                        <option value="0">了解</option>
                                        <option value="1">熟悉</option>
                                        <option value="2">掌握</option>
                                        <option value="3">精通</option>
                                    </select>
                                </div>
                            </div>
                        </div>
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

    <%@ include file="common/foot.jsp" %>
    <script>
        addValidatorRules('.form-validation')

        const $formBox = $('#add-form-box')
        const $form = $formBox.find('form')
        function add() {
            $($form)[0].reset()
            $formBox.modal()
        }

        function edit(bean) {
            for (const key in bean) {
                $form.find('[name=' + key + ']').val(bean[key])
            }
            $formBox.modal()
        }

        function remove(id, name, btn) {
            const $tr = $(btn).parents('tr')
            const $check = $tr.find('input')
            const checked = $check.prop("checked")
            if (!checked) {
                $check.prop("checked", true)
                $tr.addClass('active')
            }
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
                if (!willDelete) {
                    if (!checked) {
                        $check.prop("checked", false)
                        $tr.removeClass('active')
                    }
                    return
                }
                $('#remove-form').submit()
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
                $('#remove-form').submit()
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
