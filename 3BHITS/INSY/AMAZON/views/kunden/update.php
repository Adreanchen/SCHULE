<?php

use yii\helpers\Html;

/** @var yii\web\View $this */
/** @var app\models\Kunden $model */

$this->title = Yii::t('app', 'Update Kunden: {name}', [
    'name' => $model->KundenID,
]);
$this->params['breadcrumbs'][] = ['label' => Yii::t('app', 'Kundens'), 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->KundenID, 'url' => ['view', 'KundenID' => $model->KundenID]];
$this->params['breadcrumbs'][] = Yii::t('app', 'Update');
?>
<div class="kunden-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
